package com.ticketingsystem.model.entities;

import com.ticketingsystem.model.enums.CategoriaEnum;

public class Ingresso {
    private String code;
    private Evento evento;
    private CategoriaEnum categoria;
    private Double valor;
    private Usuario usuario;

    public Ingresso(){}

    public Ingresso(String code, Evento evento, CategoriaEnum categoria, Double valor) {
        this.code = code;
        this.evento = evento;
        this.categoria = categoria;
        this.valor = valor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
