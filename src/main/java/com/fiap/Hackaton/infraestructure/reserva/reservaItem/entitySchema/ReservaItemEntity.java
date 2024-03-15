package com.fiap.Hackaton.infraestructure.reserva.reservaItem.entitySchema;

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
    private ReservaEntity reservaEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    public ReservaItemEntity() {
    }
    public ReservaItemEntity(Long id, Integer quantidade, ReservaEntity reservaEntity, ItemEntity itemEntity) {
        this.id = id;
        this.quantidade = quantidade;
        this.reservaEntity = reservaEntity;
        this.itemEntity = itemEntity;
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

    public ReservaEntity getReservaEntity() {
        return reservaEntity;
    }

    public void setReservaEntity(ReservaEntity reservaEntity) {
        this.reservaEntity = reservaEntity;
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }
}
