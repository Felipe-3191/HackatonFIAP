package com.fiap.Hackaton.infraestructure.predio.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;

public record PredioPublicResponseAddData (
        Long id,
        String nome
) {
    public PredioPublicResponseAddData(Predio predio) {
        this (
                predio.getId(),
                predio.getNome()
        );
    }
}
