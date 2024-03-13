package com.fiap.Hackaton.infraestructure.predio.entityschema;



import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.infraestructure.hotel.entityschema.HotelEntity;
import jakarta.persistence.*;


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


    public PredioEntity(){}

    public PredioEntity(Predio predio){
        this.id = predio.getId();
        this.nome = predio.getNome();
        this.hotel = new HotelEntity(predio.getHotel());
    }


    public Predio toEntity() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity()
        );
        return predio;
    }


    public PredioEntity(Long id, String nome, HotelEntity hotel) {
        this.id = id;
        this.nome = nome;
        this.hotel = hotel;
    }


}