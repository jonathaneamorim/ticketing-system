package com.ticketingsystem.model.entities;

import com.ticketingsystem.model.enums.FormaPagamentoEnum;
import com.ticketingsystem.model.enums.StatusPagamentoEnum;

public class Pagamento {
    private FormaPagamentoEnum formaPagamentoEnum;
    private Ingresso ingresso;
    private StatusPagamentoEnum  statusPagamento;

    public Pagamento(){}

    public Pagamento(FormaPagamentoEnum formaPagamentoEnum, Ingresso ingresso, StatusPagamentoEnum statusPagamento) {
        this.formaPagamentoEnum = formaPagamentoEnum;
        this.ingresso = ingresso;
        this.statusPagamento = statusPagamento;
    }

    public FormaPagamentoEnum getFormaPagamentoEnum() {
        return formaPagamentoEnum;
    }

    public void setFormaPagamentoEnum(FormaPagamentoEnum formaPagamentoEnum) {
        this.formaPagamentoEnum = formaPagamentoEnum;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public StatusPagamentoEnum getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamentoEnum statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
