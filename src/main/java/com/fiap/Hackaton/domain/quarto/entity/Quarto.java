package com.fiap.Hackaton.domain.quarto.entity;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public class Quarto {

    private Long id;
    private Predio predio;
    private Long idHotel;
    private BigDecimal valorDiaria;
    private Status status;
    private TipoQuarto tipoQuarto;


    public Quarto() {
    }

    public Quarto(Predio predio, TipoQuarto tipoQuarto, Status status, BigDecimal valorDiaria) {
        this.predio = predio;
        this.tipoQuarto = tipoQuarto;
        this.status = status;
        this.valorDiaria = valorDiaria;
    }

    public Quarto(Long id, Predio predio, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.predio = predio;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto(Long id, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto(Long id, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
}
