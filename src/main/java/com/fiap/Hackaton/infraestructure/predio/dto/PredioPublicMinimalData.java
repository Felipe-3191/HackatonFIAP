package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoHotelPublicData;

import java.util.List;
import java.util.stream.Collectors;

public record PredioPublicMinimalData(

        Long id,
        String nome,
        List<QuartoHotelPublicData> quartos


) {

    public PredioPublicMinimalData(Predio predio) {
        this(
                predio.getId(),
                predio.getNome(),
                predio.getQuartos().stream().map(QuartoHotelPublicData::new).collect(Collectors.toList())
        );
    }
}
