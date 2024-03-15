package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoSummaryPublicData;

import java.util.List;

public record PredioPublicData (

         Long id,
         String nome,
         List<QuartoSummaryPublicData> quartos


) {
    public PredioPublicData(Predio predio) {
        this(
                new HotelPublicData(predio.getHotel()),
                predio.getId(),
                predio.getNome(),
                predio.getQuartos().stream().map(QuartoSummaryPublicData::new).toList()
        );
    }
}
