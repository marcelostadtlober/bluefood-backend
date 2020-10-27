package br.com.mstadtlober.bluefood.domain.pedido;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("SELECT p FROM Pedido p WHERE p.cliente.id = ?1 ORDER BY p.data DESC")
	List<Pedido> findByCliente_id(Integer clienteId);
	
	List<Pedido> findByRestaurante_IdOrderByDataDesc(Integer restauranteId);
	
	Pedido findByIdAndRestaurante_Id(Integer pedidoId, Integer restauranteId);
	
	@Query("SELECT p FROM Pedido p WHERE p.restaurante.id = ?1 AND p.data BETWEEN ?2 AND ?3")
	List<Pedido> findByDateInterval(Integer restauranteId, LocalDateTime dataInicial, LocalDateTime dataFinal);

}
