package br.com.mstadtlober.bluefood.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mstadtlober.bluefood.domain.cliente.Cliente;
import br.com.mstadtlober.bluefood.domain.cliente.ClienteRepository;
import br.com.mstadtlober.bluefood.domain.restaurante.Restaurante;
import br.com.mstadtlober.bluefood.domain.restaurante.RestauranteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RestauranteRepository restauranteRespository;
	
	@Transactional
	public void saveCliente(Cliente cliente) throws ValidationException {
		if (!validateEmail(cliente.getEmail(), cliente.getId())) {
			throw new ValidationException("O e-mail est� duplicado");
		}
		
		if (cliente.getId() != null) {
			Cliente clienteDB = clienteRepository.findById(cliente.getId()).orElseThrow();
			cliente.setSenha(clienteDB.getSenha());
			
		} else {
			cliente.encryptPassword();
		}
		
		clienteRepository.save(cliente);
	}
	
	private boolean validateEmail(String email, Integer id) {
		Restaurante restaurante = restauranteRespository.findByEmail(email);
		
		if (restaurante != null) {
			return false;
		}
		
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if (cliente != null) {
			if (id == null) {
				return false;
			}
			
			if (!cliente.getId().equals(id)) {
				return false;
			}
		}
		
		return true;
	}

}
