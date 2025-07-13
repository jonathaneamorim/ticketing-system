package com.ticketingsystem.model.enums;

public enum CategoriaEnum {
    MEIA("Meia-Entrada"),
    INTEIRA("Inteira");

    private final String descricao;

    CategoriaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
