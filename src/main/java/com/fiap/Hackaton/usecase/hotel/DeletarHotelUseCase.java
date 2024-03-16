package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;

public class DeletarHotelUseCase {

    private final HotelGateway hotelGateway;

    private final PredioGateway predioGateway;
    public DeletarHotelUseCase(HotelGateway hotelGateway, PredioGateway predioGateway) {
        this.hotelGateway = hotelGateway;
        this.predioGateway = predioGateway;
    }

    public void executar(Long id) {
        Hotel hotel = this.hotelGateway.buscarPorId(id).orElseThrow();
        this.predioGateway.removerReferenciaHotel(hotel);
        this.hotelGateway.deletar(hotel);

    }

}
