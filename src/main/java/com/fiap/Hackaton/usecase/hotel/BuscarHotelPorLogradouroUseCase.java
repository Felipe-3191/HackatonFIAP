package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

import java.util.List;

public class BuscarHotelPorLogradouroUseCase {

    private final HotelGateway hotelGateway;

    public BuscarHotelPorLogradouroUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }


    public List<Hotel> executar(String logradouro){
        return this.hotelGateway.buscarPorLogradouro(logradouro).orElseThrow();


    }


}
