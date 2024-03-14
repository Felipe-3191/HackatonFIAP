package com.fiap.Hackaton.domain.quarto.tipoquarto.entity;

import com.fiap.Hackaton.domain.movel.entity.Movel;

import java.util.List;

public class TipoQuarto {
    private Long id;
    private String nomeTipo;
    private Integer capacidadeTotal;
    private Integer quantidadeCamas;

    private List<Movel> moveis;

    public TipoQuarto(){}

    public TipoQuarto(Long id, String nomeTipo, Integer capacidadeTotal, Integer quantidadeCamas) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
    }
    public TipoQuarto(Long id, String nomeTipo, Integer capacidadeTotal, Integer quantidadeCamas, List<Movel> moveis) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
        this.moveis = moveis;
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

    public void setId(Long id){
        this.id = id;
    }

    public void setNomeTipo(String nomeTipo){
        this.nomeTipo = nomeTipo;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal){
        this.capacidadeTotal = capacidadeTotal;
    }

    public void setQuantidadeCamas(Integer quantidadeCamas){
        this.quantidadeCamas = quantidadeCamas;
    }

    public List<Movel> getMoveis(){
        return moveis;
    }

    public void setMoveis(List<Movel> moveis){
        this.moveis = moveis;
    }
}
