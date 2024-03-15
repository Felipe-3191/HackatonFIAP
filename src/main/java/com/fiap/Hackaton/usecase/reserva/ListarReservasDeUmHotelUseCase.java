package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasDeUmHotelUseCase {
    private final ReservaGateway reservaGateway;

    public ListarReservasDeUmHotelUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public List<Reserva> executar(Long idHotel) {
        return reservaGateway.listarPorHotel(idHotel);
    }
}
