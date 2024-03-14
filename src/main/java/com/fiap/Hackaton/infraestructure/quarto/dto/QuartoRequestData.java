package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record QuartoRequestData (

    @NotBlank(message = "Predio é obrigatório")
    Predio predio,
    @NotBlank(message = "Tipo Quarto é obrigatório")
    TipoQuarto tipoQuarto,
    Status status,
    @NotBlank(message = "Valor da diaria é obrigatório")
    BigDecimal valorDiaria

) implements IQuartoRequestData {
}
