package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;

import java.util.List;

public record PredioPublicData (

         Hotel hotel,
         Long id,
         String nome,
         List<Quarto>quartos


) {
    public PredioPublicData(Predio predio) {
        this(
                predio.getHotel(),
                predio.getId(),
                predio.getNome(),
                predio.getQuartos()
        );
    }
}
