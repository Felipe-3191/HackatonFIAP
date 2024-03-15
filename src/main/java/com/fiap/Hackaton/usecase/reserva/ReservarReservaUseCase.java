package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.Hackaton.usecase.reserva.dto.IReservaReservarRequestData;

public class ReservarReservaUseCase {
    private final ReservaGateway reservaGateway;

    public ReservarReservaUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public Reserva executar(IReservaReservarRequestData dados) {
        Reserva reserva = new Reserva(dados.idCliente(), dados.idQuartos(), dados.dataInicio(),
                dados.dataFim(), dados.servicos(), dados.itens(), dados.quantidadePessoas());

        return this.reservaGateway.reservar(reserva);
    }
}
