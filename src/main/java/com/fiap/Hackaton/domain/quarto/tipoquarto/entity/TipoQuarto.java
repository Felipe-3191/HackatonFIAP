package com.fiap.Hackaton.domain.quarto.tipoquarto.entity;

public class TipoQuarto {
    private Long id;
    private String nomeTipo;
    private Integer capacidadeTotal;
    private Integer quantidadeCamas;



    public TipoQuarto(){}

    public TipoQuarto(Long id, String nomeTipo, Integer capacidadeTotal, Integer quantidadeCamas) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
    }

    public Long getId() {
        return id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public Integer getQuantidadeCamas() {
        return quantidadeCamas;
    }
}
