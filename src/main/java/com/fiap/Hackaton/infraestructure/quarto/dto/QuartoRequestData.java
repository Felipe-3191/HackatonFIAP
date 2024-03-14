package com.fiap.Hackaton.infraestructure.quarto.dto;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.usecase.quarto.dto.IQuartoRequestData;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record QuartoRequestData (

    @Min(value = 1, message = "Id do predio deve ser informado")
   Long idPredio,
    @Min(value = 1, message = "Id do tipo quarto deve ser informado")
    Long idTipoQuarto,
    String status,
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=6, fraction=2)
    BigDecimal valorDiaria

) implements IQuartoRequestData {
}
