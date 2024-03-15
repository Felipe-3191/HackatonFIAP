package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.exception.ItemNaoEncontradoException;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;

import java.util.List;

public class BuscarTodosItensUseCase {
    private final ItemGateway itemGateway;

    public BuscarTodosItensUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute() {
        List<Item> itens = this.itemGateway.listar();

        if (itens.isEmpty()) {
            throw new ItemNaoEncontradoException();
        }

        return itens;
    }
}