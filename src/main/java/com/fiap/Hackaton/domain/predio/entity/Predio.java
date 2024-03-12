package com.fiap.Hackaton.domain.predio.entity;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;

import java.util.ArrayList;
import java.util.List;

public class Predio {

    private Long id;
    private String nome;
    private List<Quarto> quartos;


    public Predio(){

    }

    public Predio(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.quartos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }
}
