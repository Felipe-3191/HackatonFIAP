package com.fiap.Hackaton.domain.quarto.entity;

import com.fiap.Hackaton.domain.movel.entity.Movel;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Quarto {

    private Long id;
    private BigDecimal valorDiaria;
    private Status status;
    private TipoQuarto tipoQuarto;
    private List<Movel> moveis;


    public Quarto(){}
    public Quarto(Long id, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
        this.moveis = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public Status getStatus() {
        return status;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public List<Movel> getMoveis() {
        return moveis;
    }
}
