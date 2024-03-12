package com.fiap.Hackaton.domain.hotel.servico.entity;

import java.math.BigDecimal;

public class Servico {

    private Long id;
    private String nome;
    private BigDecimal valor;


    public Servico(){}
    public Servico(Long id, String nome, BigDecimal valor) {
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
