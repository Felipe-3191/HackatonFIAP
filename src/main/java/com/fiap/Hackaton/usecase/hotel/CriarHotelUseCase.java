package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.usecase.hotel.dto.IHotelCadastroRequestData;

public class CriarHotelUseCase {

    private final HotelGateway hotelGateway;


    public CriarHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public Hotel executar(IHotelCadastroRequestData dados) {

        Endereco endereco = new Endereco(
                dados.endereco().estado(),
                dados.endereco().logradouro(),
                dados.endereco().cep(),
                dados.endereco().cidade()
        );


        Hotel hotel = new Hotel(
                dados.nome(),
                endereco
        );


        return this.hotelGateway.criar(hotel);

    }

}
