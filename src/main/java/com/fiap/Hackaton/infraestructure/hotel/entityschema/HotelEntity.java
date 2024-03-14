package com.fiap.Hackaton.infraestructure.hotel.entityschema;




import com.fiap.Hackaton.domain.amenidade.entity.Amenidade;
import com.fiap.Hackaton.domain.hotel.entity.Hotel;

import com.fiap.Hackaton.infraestructure.amenidade.entityschema.AmenidadeEntity;
import com.fiap.Hackaton.infraestructure.endereco.entityschema.EnderecoEntity;
import com.fiap.Hackaton.infraestructure.predio.entityschema.PredioEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;
    private String nome;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "hotel")
    private List<PredioEntity> predios = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "hotel_amenidades",
    joinColumns = @JoinColumn(name = "hotel_id"),
    inverseJoinColumns = @JoinColumn(name = "amenidade_id"))
    private Set<AmenidadeEntity> amenidades = new HashSet<>();



    public HotelEntity(){}

    public HotelEntity(Hotel hotel){
        this.id = hotel.getId();
        this.nome = hotel.getNome();
        this.endereco = new EnderecoEntity(hotel.getEndereco());
    }

    public Hotel toEntity(){

        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity()
        );


    }

    public Hotel toCompleteEntity() {
        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity(),
                this.predios.stream().map(PredioEntity::toEntity).collect(Collectors.toList()),
                this.amenidades.stream().map(AmenidadeEntity::toEntity).collect(Collectors.toList()),
                null,
                null


        );
    }


    public Hotel toEntityWithPredios(){

        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity(),
                this.predios.stream().map(PredioEntity::toEntity).collect(Collectors.toList())
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<PredioEntity> getPredios() {
        return predios;
    }

    public void setPredios(List<PredioEntity> predios) {
        this.predios = predios;
    }

    public Set<AmenidadeEntity> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(Set<AmenidadeEntity> amenidades) {
        this.amenidades = amenidades;
    }
}
