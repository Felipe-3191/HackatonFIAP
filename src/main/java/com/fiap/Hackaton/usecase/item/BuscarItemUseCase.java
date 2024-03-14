package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.exception.ItemNaoEncontradoException;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;

import java.util.Optional;

public class BuscarItemUseCase {

    private final ItemGateway itemGateway;

    public BuscarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item execute(Long id) {
        Optional<Item> item = this.itemGateway.buscarPorId(id);
        if(item.isEmpty()) {
            throw new ItemNaoEncontradoException();
        }

        return item.get();
    }
}