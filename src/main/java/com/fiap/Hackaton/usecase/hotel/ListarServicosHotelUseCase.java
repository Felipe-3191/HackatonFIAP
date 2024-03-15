package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;

import java.util.List;

public class ListarServicosHotelUseCase {
    private final HotelGateway hotelGateway;

    public ListarServicosHotelUseCase(HotelGateway hotelGateway){
        this.hotelGateway = hotelGateway;
    }

    public List<Servico> executar(Long id) {
        Hotel hotel = hotelGateway.buscarPorId(id).orElseThrow();
        return hotel.getServicosDisponiveis();
    }
}
