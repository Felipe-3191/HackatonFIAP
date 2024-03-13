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

    public Servico(String nome, BigDecimal valor) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
