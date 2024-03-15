package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.usecase.predio.dto.IPredioRequestData;

public record PredioRequestData(
        String nome


) implements IPredioRequestData {
}
