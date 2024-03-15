package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

import java.time.LocalDate;
import java.util.List;

public class ListarReservasDeUmPeriodoUseCase {

    private final ReservaGateway reservaGateway;

    public ListarReservasDeUmPeriodoUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public List<Reserva> executar(LocalDate inicio, LocalDate fim) {
        return reservaGateway.listarPorPeriodo(inicio, fim);
    }
}
