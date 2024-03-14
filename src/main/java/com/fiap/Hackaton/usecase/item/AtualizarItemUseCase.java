package com.fiap.Hackaton.usecase.item;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.dto.ItemRequestData;

public class AtualizarItemUseCase {

    private final ItemGateway itemGateway;

    public AtualizarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item execute(Long id, ItemRequestData dados) {

        Item item = this.itemGateway.buscarPorId(id).orElseThrow();

        Item itemAtualizado = this.atualizarItem(item, dados);

        return this.itemGateway.atualizar(itemAtualizado);
    }


    private Item atualizarItem(Item item, ItemRequestData dados) {
        item.setNome(dados.nome());
        item.setValor(dados.valor());
        return item;
    }
}