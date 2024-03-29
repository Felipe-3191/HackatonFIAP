package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

import java.util.List;

public class BuscarHotelPorNomeUseCase {

    private final HotelGateway hotelGateway;

    public BuscarHotelPorNomeUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }


    public List<Hotel> executar(String nome) {
        return this.hotelGateway.buscarPorNome(nome).orElseThrow();


    }

}
