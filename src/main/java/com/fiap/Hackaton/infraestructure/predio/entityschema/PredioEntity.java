package com.fiap.Hackaton.infraestructure.predio.entityschema;


import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.infraestructure.hotel.entityschema.HotelEntity;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "predio")
public class PredioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "predio_id")
    private List<QuartoEntity> quartoEntities;

    public PredioEntity() {
    }

    public PredioEntity(Predio predio) {
        this.id = predio.getId();
        this.nome = predio.getNome();
        this.hotel = new HotelEntity(predio.getHotel());
        List<QuartoEntity> quartos = new ArrayList<>();
        for (Quarto quarto : predio.getQuartos()) {
            quartos.add(new QuartoEntity(quarto));
        }
        this.quartoEntities = quartos;
    }


    public PredioEntity(Long id, String nome, HotelEntity hotel) {
        this.id = id;
        this.nome = nome;
        this.hotel = hotel;
    }

    public Predio toSimpleEntity() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity()
        );
        return predio;
    }

    public Predio toEntity() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity()
        );
        return predio;
    }

    public Predio toEntityWithQuartos() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity(),
                this.quartoEntities.stream().map(QuartoEntity::toEntityWithPredio).collect(Collectors.toList())
        );
        return predio;
    }

    public Predio toEntityWithoutHotel() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.quartoEntities.stream().map(QuartoEntity::toEntityToPredio).collect(Collectors.toList())
        );
        return predio;
    }

}
