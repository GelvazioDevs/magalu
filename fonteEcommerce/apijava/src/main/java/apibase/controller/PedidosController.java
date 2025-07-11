package apibase.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    // Simulação de armazenamento em memória
    private final Map<Long, PedidoDTO> pedidos = new HashMap<>();
    private long nextId = 1;

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedido(@PathVariable Long id) {
        PedidoDTO pedido = pedidos.get(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedido) {
        pedido.setId(nextId++);
        pedidos.put(pedido.getId(), pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoAtualizado) {
        PedidoDTO existente = pedidos.get(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        pedidoAtualizado.setId(id);
        pedidos.put(id, pedidoAtualizado);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        if (!pedidos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidos.remove(id);
        return ResponseEntity.noContent().build();
    }

    // DTO interno para simplificação
    public static class PedidoDTO {
        private Long id;
        private String usuario;
        private LocalDate dataPedido;
        private String status; // Pendente, Aprovado, Em Preparação, Enviado, Entregue, Cancelado
        private Double valorTotal;
        private Double valorFrete;
        private Double valorDescontos;
        private String metodoPagamento; // Cartão, PIX, Boleto
        private String statusPagamento; // Pendente, Aprovado, Recusado, Reembolsado
        private String enderecoEntrega;
        private String codigoRastreamento;
        private LocalDate dataEntregaPrevista;
        private LocalDate dataEntregaReal;

        // Getters e Setters

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getUsuario() { return usuario; }
        public void setUsuario(String usuario) { this.usuario = usuario; }

        public LocalDate getDataPedido() { return dataPedido; }
        public void setDataPedido(LocalDate dataPedido) { this.dataPedido = dataPedido; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public Double getValorTotal() { return valorTotal; }
        public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

        public Double getValorFrete() { return valorFrete; }
        public void setValorFrete(Double valorFrete) { this.valorFrete = valorFrete; }

        public Double getValorDescontos() { return valorDescontos; }
        public void setValorDescontos(Double valorDescontos) { this.valorDescontos = valorDescontos; }

        public String getMetodoPagamento() { return metodoPagamento; }
        public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }

        public String getStatusPagamento() { return statusPagamento; }
        public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }

        public String getEnderecoEntrega() { return enderecoEntrega; }
        public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }

        public String getCodigoRastreamento() { return codigoRastreamento; }
        public void setCodigoRastreamento(String codigoRastreamento) { this.codigoRastreamento = codigoRastreamento; }

        public LocalDate getDataEntregaPrevista() { return dataEntregaPrevista; }
        public void setDataEntregaPrevista(LocalDate dataEntregaPrevista) { this.dataEntregaPrevista = dataEntregaPrevista; }

        public LocalDate getDataEntregaReal() { return dataEntregaReal; }
        public void setDataEntregaReal(LocalDate dataEntregaReal) { this.dataEntregaReal = dataEntregaReal; }
    }
}