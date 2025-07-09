package com.ticketingsystem.model.entities;

import java.time.LocalDate;

public class Administrador extends Usuario{
    private String nomeOrganizador;
    private String senha;

    public Administrador() {
        super();
    }

    public Administrador(int id, String cpf, String nome, LocalDate dataNascimento, String email, String nomeOrganizador, String senha) {
        super(id, cpf, nome, dataNascimento, email);
        this.nomeOrganizador = nomeOrganizador;
        this.senha = senha;
    }

    public String getNomeOrganizador() {
        return nomeOrganizador;
    }

    public void setNomeOrganizador(String nomeOrganizador) {
        this.nomeOrganizador = nomeOrganizador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
