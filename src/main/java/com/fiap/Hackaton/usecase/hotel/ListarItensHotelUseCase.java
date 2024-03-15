package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;

import java.util.List;

public class ListarItensHotelUseCase {

    private final HotelGateway hotelGateway;

    public ListarItensHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public List<Item> executar(Long id) {
        Hotel hotel = hotelGateway.buscarPorId(id).orElseThrow();
        return hotel.getItensDiponiveis();
    }

}
