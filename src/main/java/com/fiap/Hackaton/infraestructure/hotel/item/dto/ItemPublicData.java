package com.fiap.Hackaton.infraestructure.hotel.item.dto;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.usecase.item.dto.IItemPublicData;

import java.math.BigDecimal;

public record ItemPublicData(
        Long id,
        String nome,
        BigDecimal valor
) implements IItemPublicData {

    public ItemPublicData(Item item) {
        this(
                item.getId(),
                item.getNome(),
                item.getValor()
        );
    }
}