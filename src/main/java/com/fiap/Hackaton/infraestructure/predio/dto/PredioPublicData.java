package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelPublicData;

import java.util.List;

public record PredioPublicData(

        HotelPublicData hotel,
        Long id,
        String nome,
        List<Quarto> quartos


) {
    public PredioPublicData(Predio predio) {
        this(
                new HotelPublicData(predio.getHotel()),
                predio.getId(),
                predio.getNome(),
                predio.getQuartos()
        );
    }
}
