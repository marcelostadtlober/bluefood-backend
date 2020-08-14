package br.com.mstadtlober.bluefood.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mstadtlober.bluefood.domain.cliente.Cliente;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/cliente/new")
	public String newCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		
		return "cliente-cadastro";
	}

}
