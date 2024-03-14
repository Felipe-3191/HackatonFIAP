package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;

public class BuscarItemUseCase {

    private final ItemGateway itemGateway;

    public BuscarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item execute(Long id) {
        return this.itemGateway.buscarPorId(id).orElseThrow();
    }
}