package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

public class DeletarHotelUseCase {

    private final HotelGateway hotelGateway;

    public DeletarHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public void executar(Long id) {
        Hotel hotel = this.hotelGateway.buscarPorId(id).orElseThrow();

        this.hotelGateway.deletar(hotel);

    }

}
