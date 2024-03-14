package com.fiap.Hackaton.domain.cliente.entity;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoPaisOrigem;
    private String telefone;
    private String email;

public Cliente(){};



    public Cliente(String paisOrigem, String cpf, String passaporte, String nome
            , LocalDate dataNascimento, String enderecoPaisOrigem, String telefone, String email) {
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }



    public Cliente(Long id, String paisOrigem, String cpf, String passaporte, String nome
            , LocalDate dataNascimento, String enderecoPaisOrigem, String telefone, String email) {
        this.id = id;
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEnderecoPaisOrigem() {
        return enderecoPaisOrigem;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }


    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEnderecoPaisOrigem(String enderecoPaisOrigem) {
        this.enderecoPaisOrigem = enderecoPaisOrigem;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id){
        this.id = id;
    }
}
