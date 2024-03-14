package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoPublicData;

import java.math.BigDecimal;

public record QuartoSummaryPublicData (Long id,
                                       Status status,
                                       BigDecimal valorDiaria,
                                       TipoQuarto tipoQuarto
) {

    public QuartoSummaryPublicData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getStatus(),
                quarto.getValorDiaria(),
                quarto.getTipoQuarto()
        );
    }
}
