package com.fiap.Hackaton.domain.reserva.entity;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Reserva {

    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private BigDecimal valorReserva;
    private BigDecimal valorTotal;
    private Integer quantidadePessoas;
    private Cliente responsavelReserva;
    private List<Quarto> quartosReservados;
    private List<Item> itensConsumidos;
    private List<Servico> servicosConsumidos;


    public Reserva(){}

    public Reserva(Long id, LocalDate dataInicial, LocalDate dataFinal, BigDecimal valorReserva,
                   BigDecimal valorTotal, Integer quantidadePessoas, Cliente responsavelReserva,
                   List<Quarto> quartosReservados, List<Item> itensConsumidos, List<Servico> servicosConsumidos) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorReserva = valorReserva;
        this.valorTotal = valorTotal;
        this.quantidadePessoas = quantidadePessoas;
        this.responsavelReserva = responsavelReserva;
        this.quartosReservados = quartosReservados;
        this.itensConsumidos = itensConsumidos;
        this.servicosConsumidos = servicosConsumidos;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public BigDecimal getValorReserva() {
        return valorReserva;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public Cliente getResponsavelReserva() {
        return responsavelReserva;
    }

    public List<Quarto> getQuartosReservados() {
        return quartosReservados;
    }

    public List<Item> getItensConsumidos() {
        return itensConsumidos;
    }

    public List<Servico> getServicosConsumidos() {
        return servicosConsumidos;
    }
}
