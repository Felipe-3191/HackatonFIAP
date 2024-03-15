package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.predio.dto.PredioPublicResponseAddData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelPrediosPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<PredioPublicResponseAddData> predios


) {
    public HotelPrediosPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getPredios().stream().map(predio -> new PredioPublicResponseAddData(predio)).collect(Collectors.toList())
        );
    }

}
