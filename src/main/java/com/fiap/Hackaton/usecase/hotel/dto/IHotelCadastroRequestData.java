package com.fiap.Hackaton.usecase.hotel.dto;

import com.fiap.Hackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;

public interface IHotelCadastroRequestData {
    String nome();

    EnderecoCadastroRequestData endereco();
}
