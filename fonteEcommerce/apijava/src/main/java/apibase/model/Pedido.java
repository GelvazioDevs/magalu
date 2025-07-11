package apibase.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    private Long usuarioId;
    private LocalDateTime dataPedido;
    private StatusPedido status;
    private BigDecimal valorTotal;
    private BigDecimal valorFrete;
    private BigDecimal valorDescontos;
    private MetodoPagamento metodoPagamento;
    private StatusPagamento statusPagamento;
    private String enderecoEntrega;
    private String codigoRastreamento;
    private LocalDateTime dataEntregaPrevista;
    private LocalDateTime dataEntregaReal;
    
    public Long getId() {
        return this.id != null ? this.id : 0L;
    }
    

    public enum StatusPedido {
        PENDENTE, APROVADO, EM_PREPARACAO, ENVIADO, ENTREGUE, CANCELADO
    }

    public enum MetodoPagamento {
        CARTAO, PIX, BOLETO
    }

    public enum StatusPagamento {
        PENDENTE, APROVADO, RECUSADO, REEMBOLSADO
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}