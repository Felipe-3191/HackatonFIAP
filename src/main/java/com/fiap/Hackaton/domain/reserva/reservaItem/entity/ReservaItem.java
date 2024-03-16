package com.fiap.Hackaton.domain.reserva.reservaItem.entity;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaItem.dto.ReservaItemRequestData;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;

public class ReservaItem {

    private Long id;
    private Integer quantidade;
    private Reserva reserva;
    private Item item;

    public ReservaItem() {
    }
    public ReservaItem(Long id, Integer quantidade, Reserva reserva, Item item) {
        this.id = id;
        this.quantidade = quantidade;
        this.reserva = reserva;
        this.item = item;
    }
    public ReservaItem(ReservaItemRequestData reservaItemRequestData){
        this.quantidade = reservaItemRequestData.quantidade();
        this.item = new Item(reservaItemRequestData.idItem());
    }

    public ReservaItem(Long id, Integer quantidade, ItemEntity item) {
        this.id = id;
        this.quantidade = quantidade;
        this.item = item.toEntity();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
