package com.fiap.Hackaton.infraestructure.reserva.reservaItem.entitySchema;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva_item")
public class ReservaItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reserva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    public ReservaItemEntity() {
    }
    public ReservaItemEntity(Long id, Integer quantidade, ReservaEntity reserva, ItemEntity item) {
        this.id = id;
        this.quantidade = quantidade;
        this.reserva = reserva;
        this.item = item;
    }

    public ReservaItemEntity (ReservaItem reservaItem){
        this.id = reservaItem.getId();
        this.quantidade = reservaItem.getQuantidade();
        if(reservaItem.getReserva() != null)
            this.reserva = new ReservaEntity(reservaItem.getReserva());
        if(reservaItem.getItem() != null)
            this.item = new ItemEntity(reservaItem.getItem());
    }

    public ReservaItemEntity(Item item){
        this.item = new ItemEntity(item);
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

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}
