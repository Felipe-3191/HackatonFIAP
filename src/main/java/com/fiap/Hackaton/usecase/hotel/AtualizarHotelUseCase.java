package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.usecase.hotel.dto.IHotelAtualizarRequestData;

import java.util.Optional;

public class AtualizarHotelUseCase {

    private final HotelGateway hotelGateway;


    public AtualizarHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public Hotel executar (Long hotelId, IHotelAtualizarRequestData dados) {
        Hotel hotel = this.hotelGateway.buscarPorId(hotelId).orElseThrow();
        hotel.setNome(dados.nome());
        hotel.setEndereco(dados.endereco());


        return this.hotelGateway.atualizar(hotel);

    }
}
