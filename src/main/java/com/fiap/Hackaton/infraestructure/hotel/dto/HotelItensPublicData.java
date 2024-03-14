package com.fiap.Hackaton.infraestructure.hotel.dto;

import com.fiap.Hackaton.domain.endereco.entity.Endereco;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.Hackaton.infraestructure.hotel.servico.dto.ServicoPublicData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelItensPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<ItemPublicData> itens

) {

    public HotelItensPublicData(Hotel hotel){
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getItensDiponiveis().stream().map(item -> new ItemPublicData(item)).collect(Collectors.toList())
        );
    }
}
