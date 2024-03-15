package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

public class BuscarReservaPorIdUseCase {

    private final ReservaGateway reservaGateway;

    public BuscarReservaPorIdUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public Reserva executar(Long id) {
        return reservaGateway.buscarPorId(id).orElseThrow();
    }
}
