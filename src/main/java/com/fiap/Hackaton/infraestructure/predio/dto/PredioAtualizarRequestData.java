package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.usecase.predio.dto.IPredioUpdateData;

public record PredioAtualizarRequestData(
        String nome
) implements IPredioUpdateData {
}
