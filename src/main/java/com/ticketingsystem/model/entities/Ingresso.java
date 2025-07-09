package com.ticketingsystem.model.entities;

import com.ticketingsystem.model.enums.CategoriaEnum;

public class Ingresso {
    private String code;
    private Evento evento;
    private Usuario usuario;
    private String assento;
    private CategoriaEnum categoria;
    private Double valor;

    public Ingresso(){}

    public Ingresso(String code, Evento evento, Usuario usuario, String assento, CategoriaEnum categoria, Double valor) {
        this.code = code;
        this.evento = evento;
        this.usuario = usuario;
        this.assento = assento;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
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
}
