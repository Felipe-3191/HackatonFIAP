package com.fiap.Hackaton.domain.hotel.entity;

import com.fiap.Hackaton.domain.amenidade.entity.Amenidade;
import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.predio.entity.Predio;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Long id;
    private String nome;
    private Endereco endereco;
    private List<Predio> predios;
    private List<Amenidade> amenidades;

    public Hotel() {}

    public Hotel(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.predios = new ArrayList<>();
        this.amenidades = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Predio> getPredios() {
        return predios;
    }

    public List<Amenidade> getAmenidades() {
        return amenidades;
    }
}
