package br.com.mstadtlober.bluefood.domain.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("SELECT p FROM Pedido p WHERE p.cliente.id = ?1 ORDER BY p.data DESC")
	List<Pedido> findByCliente_id(Integer clienteId);

}
