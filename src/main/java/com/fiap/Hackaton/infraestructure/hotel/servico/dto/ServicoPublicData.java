package com.fiap.Hackaton.infraestructure.hotel.servico.dto;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.usecase.servico.dto.IServicoPublicData;

import java.math.BigDecimal;

public record ServicoPublicData(
        Long id,
        String nome,
        BigDecimal valor
) implements IServicoPublicData {

    public ServicoPublicData(Servico servico) {
        this(
                servico.getId(),
                servico.getNome(),
                servico.getValor()
        );
    }
}