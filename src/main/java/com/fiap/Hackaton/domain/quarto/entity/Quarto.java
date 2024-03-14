package com.fiap.Hackaton.domain.quarto.entity;

import com.fiap.Hackaton.domain.movel.entity.Movel;
import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Quarto {

    private Long id;
    private Long idPredio;
    private Long idHotel;
    private BigDecimal valorDiaria;
    private Status status;
    private TipoQuarto tipoQuarto;


    public Quarto(){}

    public Quarto(Long id, Long idPredio, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto){
        this.id = id;
        this.idPredio = idPredio;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getIdPredio(){
        return idPredio;
    }

    public void setIdPredio(Long idPredio){
        this.idPredio = idPredio;
    }

    public Long getIdHotel(){
        return idHotel;
    }

    public void setIdHotel(Long idHotel){
        this.idHotel = idHotel;
    }

    public BigDecimal getValorDiaria(){
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria){
        this.valorDiaria = valorDiaria;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public TipoQuarto getTipoQuarto(){
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto){
        this.tipoQuarto = tipoQuarto;
    }
}
