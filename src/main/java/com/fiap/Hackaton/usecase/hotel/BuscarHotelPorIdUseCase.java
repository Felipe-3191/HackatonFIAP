package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

public class BuscarHotelPorIdUseCase {

    private final HotelGateway hotelGateway;


    public BuscarHotelPorIdUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public Hotel buscarPorId(Long id){
        return this.hotelGateway.buscarPorId(id).orElseThrow();
    }

}
