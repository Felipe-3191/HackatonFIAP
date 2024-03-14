package com.fiap.Hackaton.domain.movel.entity;

import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;

import java.util.List;

public class Movel {

    private Long id;
    private String nome;

    public Movel() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

