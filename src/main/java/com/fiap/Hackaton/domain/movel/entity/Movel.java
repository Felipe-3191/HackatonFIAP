package com.fiap.Hackaton.domain.movel.entity;

public class Movel {

    private Long id;
    private String nome;

    public Movel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
