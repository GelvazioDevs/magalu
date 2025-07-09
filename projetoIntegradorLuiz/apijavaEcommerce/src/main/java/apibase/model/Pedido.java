package apibase.model;
    
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "valor_frete", precision = 10, scale = 2)
    private BigDecimal valorFrete;

    @Column(name = "valor_descontos", precision = 10, scale = 2)
    private BigDecimal valorDescontos;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pagamento")
    private MetodoPagamento metodoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento")
    private StatusPagamento statusPagamento;

    @Column(name = "endereco_entrega", length = 500)
    private String enderecoEntrega;

    @Column(name = "codigo_rastreamento", length = 100)
    private String codigoRastreamento;

    @Column(name = "data_entrega_prevista")
    private LocalDateTime dataEntregaPrevista;

    @Column(name = "data_entrega_real")
    private LocalDateTime dataEntregaReal;

    // Enums para os status
    public enum StatusPedido {
        PENDENTE, APROVADO, EM_PREPARACAO, ENVIADO, ENTREGUE, CANCELADO
    }

    public enum MetodoPagamento {
        CARTAO, PIX, BOLETO
    }

    public enum StatusPagamento {
        PENDENTE, APROVADO, RECUSADO, REEMBOLSADO
    }
}