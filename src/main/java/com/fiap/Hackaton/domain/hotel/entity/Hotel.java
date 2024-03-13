package com.fiap.Hackaton.domain.hotel.entity;

import com.fiap.Hackaton.domain.amenidade.entity.Amenidade;
import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.predio.entity.Predio;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Long id;
    private String nome;
    private Endereco endereco;
    private List<Predio> predios;
    private List<Amenidade> amenidades;
    private List<Servico> servicosDisponiveis;
    private List<Item> itensDiponiveis;

    public Hotel() {}

    public Hotel(Long id, String nome, Endereco endereco, List<Predio> predios,
                 List<Amenidade> amenidades, List<Servico> servicosDisponiveis,
                 List<Item> itensDiponiveis) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.predios = predios;
        this.amenidades = amenidades;
        this.servicosDisponiveis = servicosDisponiveis;
        this.itensDiponiveis = itensDiponiveis;
    }

    public Hotel(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.predios = new ArrayList<>();
        this.amenidades = new ArrayList<>();
        this.servicosDisponiveis = new ArrayList<>();
        this.itensDiponiveis = new ArrayList<>();
    }


    public Hotel(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.predios = new ArrayList<>();
        this.amenidades = new ArrayList<>();
        this.servicosDisponiveis = new ArrayList<>();
        this.itensDiponiveis = new ArrayList<>();
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

    public List<Servico> getServicosDisponiveis() {
        return servicosDisponiveis;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Item> getItensDiponiveis() {
        return itensDiponiveis;
    }
}
