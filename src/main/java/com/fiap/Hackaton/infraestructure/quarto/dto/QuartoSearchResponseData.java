package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public record QuartoSearchResponseData(
        Long id,
        Long predioId,
        Long hotelId,
        TipoQuarto tipoQuarto,
        Status status,
        BigDecimal valorDiaria
) {

    public QuartoSearchResponseData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getPredio().getId(),
                quarto.getIdHotel(),
                quarto.getTipoQuarto(),
                quarto.getStatus(),
                quarto.getValorDiaria()
        );
    }
}
