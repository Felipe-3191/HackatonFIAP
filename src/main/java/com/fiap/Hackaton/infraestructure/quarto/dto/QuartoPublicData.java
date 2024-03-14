package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoPublicData;

import java.math.BigDecimal;

public record QuartoPublicData(
        Long id,
        Predio predio,
        TipoQuarto tipoQuarto,
        Status status,
        BigDecimal valorDiaria
) implements IQuartoPublicData {

    public QuartoPublicData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getPredio(),
                quarto.getTipoQuarto(),
                quarto.getStatus(),
                quarto.getValorDiaria()
        );
    }
}
