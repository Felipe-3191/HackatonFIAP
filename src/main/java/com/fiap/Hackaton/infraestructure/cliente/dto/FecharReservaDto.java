package com.fiap.Hackaton.infraestructure.cliente.dto;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FecharReservaDto {

    private String nomeCliente;
    private String nomeHotel;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private List<Quarto> quartosReservados;
    private BigDecimal valorTotal;
    private List<ReservaServico> servicosConsumidos = new ArrayList<>();
    private String email;

    public FecharReservaDto(String nomeCliente, String nomeHotel, LocalDate dataCheckIn, LocalDate dataCheckOut, List<Quarto> quartosReservados, BigDecimal valorTotal, List<ReservaServico> servicosConsumidos, String email) {
        this.nomeCliente = nomeCliente;
        this.nomeHotel = nomeHotel;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quartosReservados = quartosReservados;
        this.valorTotal = valorTotal;
        this.servicosConsumidos = servicosConsumidos;
        this.email = email;
    }

    public FecharReservaDto() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public List<Quarto> getQuartosReservados() {
        return quartosReservados;
    }

    public void setQuartosReservados(List<Quarto> quartosReservados) {
        this.quartosReservados = quartosReservados;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservaServico> getServicosConsumidos() {
        if(servicosConsumidos == null) {
            servicosConsumidos = new ArrayList<>();
        }
        return servicosConsumidos;
    }

    public void setServicosConsumidos(List<ReservaServico> servicosConsumidos) {
        this.servicosConsumidos = servicosConsumidos;
    }
}
