package com.example.magalu.enums;

public enum Statusagendamento {
    AGENDADO("Agendado"),
    ENVIADO("Enviado"),
    CANCELADO("Cancelado");

    private String descricao;

    Statusagendamento(String descricao) {
        this.descricao = descricao;
    }
}
