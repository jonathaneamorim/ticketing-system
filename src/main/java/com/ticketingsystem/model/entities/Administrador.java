package com.ticketingsystem.model.entities;

public class Administrador extends Usuario{
    private String nomeOrganizador;
    private String senha;

    public Administrador() {
        super();
    }

    public Administrador(String cpf, String nome, String nomeOrganizador, String senha) {
        super(cpf, nome, null, null); // Construtor da classe usuário
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

    @Override
    public String toString() {
        return this.getNome() + ";" + this.getCpf() + ";" + this.getCpf() + ";" + this.getEmail() + ";" + this.getDataNascimento() + ";" + this.getNomeOrganizador() + ";" + this.getSenha();
    }
}
