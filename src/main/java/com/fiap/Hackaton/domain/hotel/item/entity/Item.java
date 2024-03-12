package com.fiap.Hackaton.domain.hotel.item.entity;

import java.math.BigDecimal;

public class Item {

    private Long id;
    private String nome;
    private BigDecimal valor;

    public Item(){}

    public Item(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
