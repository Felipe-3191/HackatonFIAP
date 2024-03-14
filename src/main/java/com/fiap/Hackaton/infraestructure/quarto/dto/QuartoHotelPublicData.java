package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public record QuartoHotelPublicData(
        Long id,
        TipoQuarto tipoQuarto,
        Status status,
        BigDecimal valorDiaria
) {
    public QuartoHotelPublicData(Quarto quarto){
        this(
                quarto.getId(),
                quarto.getTipoQuarto(),
                quarto.getStatus(),
                quarto.getValorDiaria()
        );
    }
}
