package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;

import java.util.List;

public class BuscarHotelPorCEPUseCase {


    private final HotelGateway hotelGateway;

    public BuscarHotelPorCEPUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }


    public List<Hotel> executar(String cep){
        return this.hotelGateway.buscarPorCep(cep).orElseThrow();

    }

}
