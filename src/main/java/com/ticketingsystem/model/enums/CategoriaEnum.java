package com.ticketingsystem.model.enums;

public enum CategoriaEnum {
    GRATUIDADE(0.0),
    MEIA(50.0),
    INTEIRA(100.0),
    VIP(0.0);

    private final double valorBase;

    CategoriaEnum(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorBase() {
        return valorBase;
    }

    // public static double calcula
}
