package apibase.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apibase.model.Pedido;


@Repository


public interface PedidosRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
    List<Pedido> findByStatus(String status);
    List<Pedido> findByMetodoPagamento(String metodoPagamento);
    List<Pedido> findByStatusPagamento(String statusPagamento);
    List<Pedido> findByDataPedidoBetween(LocalDate inicio, LocalDate fim);
}