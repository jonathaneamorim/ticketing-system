package com.ticketingsystem.model.entities;

public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;
    private String pontoReferencia;

    public Endereco(){}

    public Endereco(String rua, String numero, String cep, String bairro, String cidade, String estado, String pais, String complemento, String pontoReferencia) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
        this.pontoReferencia = pontoReferencia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    @Override
    public String toString() {
        return this.rua + ","
                + this.numero + ","
                + this.cep + ","
                + this.bairro + ","
                + this.cidade + ","
                + this.estado + ","
                + this.pais + ","
                + this.complemento + ","
                + this.pontoReferencia;
    }

    public String show() {
        return "Rua: " + this.getRua() + ", " + this.getNumero() + " - " + this.getCidade() + "(" + this.getEstado() + "), " + this.getCep();
    }
}
