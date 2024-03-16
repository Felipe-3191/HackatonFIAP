package com.fiap.Hackaton.infraestructure.hotel.servico.dto;

import com.fiap.Hackaton.usecase.servico.dto.IServicoNomeData;

public record ServicoNomeData(String nome) implements IServicoNomeData {
}
