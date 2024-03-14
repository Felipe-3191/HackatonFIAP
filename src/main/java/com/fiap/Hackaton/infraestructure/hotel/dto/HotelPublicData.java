package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;

public record HotelPublicData(

         Long id,
         String nome,
         Endereco endereco



) {
    public HotelPublicData(Hotel hotel) {

        this(
        hotel.getId(),
        hotel.getNome(),
        hotel.getEndereco()

        );

    }

}
