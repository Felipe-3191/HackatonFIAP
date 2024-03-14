package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicResponseAddData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelServicosPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<ServicoPublicData> servicos


) {

    public HotelServicosPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getServicosDisponiveis().stream().map(servico -> new ServicoPublicData(servico)).collect(Collectors.toList())
        );
    }
}
