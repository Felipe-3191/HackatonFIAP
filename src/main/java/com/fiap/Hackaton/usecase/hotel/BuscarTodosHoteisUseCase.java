package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

import java.util.List;

public class BuscarTodosHoteisUseCase {

    private final HotelGateway hotelGateway;

    public BuscarTodosHoteisUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public List<Hotel> executar(){

        return this.hotelGateway.listar();


    }

}
