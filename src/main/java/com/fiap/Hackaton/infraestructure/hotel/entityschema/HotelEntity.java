package com.fiap.Hackaton.infraestructure.hotel.entityschema;




import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.infraestructure.endereco.entityschema.EnderecoEntity;
import jakarta.persistence.*;

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
}