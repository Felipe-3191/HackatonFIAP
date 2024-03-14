package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;

public class DeletarItemUseCase {

    private final ItemGateway itemGateway;

    public DeletarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public void execute(Long id) {
        Item item = this.itemGateway.buscarPorId(id).orElseThrow();
        this.itemGateway.deletar(item);
    }
}