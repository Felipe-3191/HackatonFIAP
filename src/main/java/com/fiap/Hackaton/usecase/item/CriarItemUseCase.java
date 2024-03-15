package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.Hackaton.usecase.item.dto.IItemRequestData;

import java.math.BigDecimal;

public class CriarItemUseCase {

    private final ItemGateway itemGateway;

    public CriarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item executar(IItemRequestData dados) {

        if (dados.nome().isEmpty() || dados.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid data");
        }

        Item item = new Item(
                dados.nome(), dados.valor());

        return this.itemGateway.criar(item);
    }
}