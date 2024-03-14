package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.amenidade.entity.Amenidade;
import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.predio.entity.Predio;

import java.util.List;

public record HotelCompletePublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<Predio> predios,
        List<Amenidade> amenidades,
        List<Servico> servicosDisponiveis,
        List<Item> itensDiponiveis



) {

    public HotelCompletePublicData(Hotel hotel){
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getPredios(),
                hotel.getAmenidades(),
                hotel.getServicosDisponiveis(),
                hotel.getItensDiponiveis()

        );
    }
}
