package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasDeUmClienteUseCase {
    private final ReservaGateway reservaGateway;

    public ListarReservasDeUmClienteUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public List<Reserva> executar(String cpf) {
        return reservaGateway.listarPorCliente(cpf);
    }
}
