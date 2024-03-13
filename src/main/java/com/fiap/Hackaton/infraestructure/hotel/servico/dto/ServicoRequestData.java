package com.fiap.Hackaton.infraestructure.hotel.servico.dto;

import com.fiap.Hackaton.usecase.servico.dto.IServicoRequestData;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ServicoRequestData(


        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Digits(integer = 6, fraction = 2, message = "Valor inválido")
        BigDecimal valor

)  implements IServicoRequestData {
}