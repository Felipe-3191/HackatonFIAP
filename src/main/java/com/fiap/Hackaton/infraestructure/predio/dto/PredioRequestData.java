package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.usecase.predio.dto.IPredioRequestData;

import java.util.List;

public record PredioRequestData (
        String nome,
        List<Quarto> quartos

) implements IPredioRequestData {
}
