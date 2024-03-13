package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;
import com.fiap.Hackaton.usecase.hotel.dto.IHotelCadastroRequestData;

public record HotelCadastroRequestData(
        String nome,
        EnderecoCadastroRequestData endereco


) implements IHotelCadastroRequestData {


}
