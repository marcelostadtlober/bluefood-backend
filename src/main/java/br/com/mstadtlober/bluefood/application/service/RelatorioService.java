package br.com.mstadtlober.bluefood.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mstadtlober.bluefood.domain.pedido.Pedido;
import br.com.mstadtlober.bluefood.domain.pedido.PedidoRepository;
import br.com.mstadtlober.bluefood.domain.pedido.RelatorioPedidoFilter;

@Service
public class RelatorioService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listPedido(Integer restauranteId, RelatorioPedidoFilter filter) {
		Integer pedidoId = filter.getPedidoId();
		
		if (pedidoId != null) {
			Pedido pedido = pedidoRepository.findByIdAndRestaurante_Id(pedidoId, restauranteId);
			
			return List.of(pedido);
		}
		
		LocalDate dataInicial = filter.getDataInicial();
		LocalDate dataFinal = filter.getDataFinal();
		
		if (dataInicial == null) {
			return List.of();
		}
		
		if (dataFinal == null) {
			dataFinal = LocalDate.now();
		}
		
		return pedidoRepository.findByDateInterval(restauranteId, dataInicial.atStartOfDay(), dataFinal.atTime(23, 59, 59));
	}

}
