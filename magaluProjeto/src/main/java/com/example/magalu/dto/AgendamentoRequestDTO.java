package com.example.magalu.dto;

import com.example.magalu.enums.Tipocomunicacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendamentoRequestDTO(
    @NotBlank(message = "Destinatário é obrigatório!")
    String destinatario,

    @NotBlank(message = "Mensagem é obrigatória!")
    String mensagem,

    @NotBlank(message = "Tipo de comunicação é obrigatório!")
    Tipocomunicacao tipocomunicacao,

    @NotNull(message = "Data e hora são obrigatórios!")
    // @Future(message = "A data e hora devem ser futuras!")
    String datahoraenvio
) {
    
}
