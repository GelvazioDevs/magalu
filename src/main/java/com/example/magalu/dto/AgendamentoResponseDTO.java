package com.example.magalu.dto;

import java.time.LocalDateTime;

import com.example.magalu.enums.Statusagendamento;
import com.example.magalu.enums.Tipocomunicacao;

public record AgendamentoResponseDTO(
    Long id,
    String destinatario,
    String mensagem,
    Tipocomunicacao tipocomunicacao,
    String dataHoraenvio,
    Statusagendamento status,
    LocalDateTime criadoem
) {


    
}
