package com.ticketingsystem.model.entities;

import java.time.LocalDate;

public class Venda {
    private Ingresso ingresso;
    private Pagamento pagamento;
    private Usuario usuario;
    private LocalDate data;

    public Venda(){}

    public Venda(Ingresso ingresso, Pagamento pagamento, Usuario usuario, LocalDate data) {
        this.ingresso = ingresso;
        this.pagamento = pagamento;
        this.usuario = usuario;
        this.data = data;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
