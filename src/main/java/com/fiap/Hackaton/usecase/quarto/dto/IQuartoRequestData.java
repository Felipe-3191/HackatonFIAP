package com.fiap.Hackaton.usecase.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public interface IQuartoRequestData {
    Predio predio();
    TipoQuarto tipoQuarto();
    Status status();
    BigDecimal valorDiaria();
}
