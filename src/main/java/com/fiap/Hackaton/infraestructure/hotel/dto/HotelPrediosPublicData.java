package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.predio.entity.Predio;

import java.util.List;

public record HotelPrediosPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<Predio> predios



) {
    public HotelPrediosPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getPredios()

        );
    }

}
