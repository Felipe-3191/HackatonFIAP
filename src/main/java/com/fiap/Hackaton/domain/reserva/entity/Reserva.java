package com.fiap.Hackaton.domain.reserva.entity;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
import com.fiap.Hackaton.infraestructure.reserva.reservaItem.dto.ReservaItemRequestData;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private List<ReservaItem> itensConsumidos;
    private List<ReservaServico> servicosConsumidos;


    public Reserva() {
    }

    public Reserva(Long id, LocalDate dataInicial, LocalDate dataFinal, BigDecimal valorReserva,
                   BigDecimal valorTotal, Integer quantidadePessoas, Cliente responsavelReserva,
                   List<Quarto> quartosReservados, List<ReservaItem> itensConsumidos, List<ReservaServico> servicosConsumidos) {
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

    public Reserva(Long id, LocalDate dataInicial, LocalDate dataFinal, BigDecimal valorReserva, BigDecimal valorTotal, Integer quantidadePessoas, Cliente entity, List<Quarto> list){
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorReserva = valorReserva;
        this.valorTotal = valorTotal;
        this.quantidadePessoas = quantidadePessoas;
        this.responsavelReserva = entity;
        this.quartosReservados = list;
    }
    public Reserva(Long idCLiente, List<Long> idQuartos, LocalDate dataInicio, LocalDate dataFim,
                   List<ReservaServicoRequestData> reservaServicos, List<ReservaItemRequestData> reservaItens,
                   Integer quantidadePessoas){

        this.dataInicial = dataInicio;
        this.dataFinal = dataFim;
        this.quantidadePessoas = quantidadePessoas;
        this.responsavelReserva = new Cliente(idCLiente);
        this.quartosReservados = idQuartos.stream().map(Quarto::new).toList();
        this.servicosConsumidos = reservaServicos.stream().map(ReservaServico::new).toList();
        this.itensConsumidos = reservaItens.stream().map(ReservaItem::new).toList();

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

    public List<ReservaItem> getItensConsumidos() {
        return itensConsumidos;
    }

    public List<ReservaServico> getServicosConsumidos() {
        return servicosConsumidos;
    }
}
