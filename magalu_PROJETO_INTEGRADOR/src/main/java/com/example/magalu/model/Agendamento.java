package com.example.magalu.model;

import java.time.LocalDateTime;

import com.example.magalu.enums.Statusagendamento;
import com.example.magalu.enums.Tipocomunicacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipocomunicacao tipocomunicacao;

    @Column(nullable = false)
    private String datahoraenvio;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Statusagendamento status;

    @Column(nullable = false)
    private LocalDateTime criadoem;
}
