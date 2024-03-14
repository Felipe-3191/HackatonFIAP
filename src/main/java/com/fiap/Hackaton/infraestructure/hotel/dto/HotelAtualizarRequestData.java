package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.usecase.hotel.dto.IHotelAtualizarRequestData;

public record HotelAtualizarRequestData(
        String nome,
        Endereco endereco

) implements IHotelAtualizarRequestData {

}
