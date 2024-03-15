package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

public class DeletarReservaPorIdUseCase {

    private final ReservaGateway reservaGateway;

    public DeletarReservaPorIdUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public void executar(Long id) {
        Reserva reserva = this.reservaGateway.buscarPorId(id).orElseThrow();
        this.reservaGateway.deletar(reserva);
    }

}
