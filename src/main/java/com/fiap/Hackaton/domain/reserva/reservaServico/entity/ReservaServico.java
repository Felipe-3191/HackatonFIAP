package com.fiap.Hackaton.domain.reserva.reservaServico.entity;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;

public class ReservaServico {

    private Long id;
    private Reserva reserva;
    private Servico servico;
    private Integer quantidade;

    public ReservaServico() {
    }

    public ReservaServico(Long id, Reserva reserva, Servico servico, Integer quantidade) {
        this.id = id;
        this.reserva = reserva;
        this.servico = servico;
        this.quantidade = quantidade;
    }

    public ReservaServico(ReservaServicoRequestData reservaServicoRequestData) {
        this.servico = new Servico(reservaServicoRequestData.idServico());
        this.quantidade = reservaServicoRequestData.quantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
