package com.ticketingsystem.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String id;
    private String nome;
    private LocalDate data;
    private String descricao;
    private String avisos;
    private Endereco endereco;
    private int classificacaoIndicativa;
    private List<String> atracoes = new ArrayList<>();
    private List<String> patrocinadores = new ArrayList<>();

    public Evento() {}

    public Evento(String id, String nome, LocalDate data, String descricao, String avisos, Endereco endereco, int classificacaoIndicativa, List<String> atracoes, List<String> patrocinadores) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.avisos = avisos;
        this.endereco = endereco;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.atracoes = atracoes;
        this.patrocinadores = patrocinadores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public List<String> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<String> atracoes) {
        this.atracoes = atracoes;
    }

    public List<String> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(List<String> patrocinadores) {
        this.patrocinadores = patrocinadores;
    }
}
