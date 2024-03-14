package com.fiap.Hackaton.infraestructure.movel.entityschema;

import com.fiap.Hackaton.domain.movel.entity.Movel;
import com.fiap.Hackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="movel")
public class MovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "tipo_quarto_movel",
            joinColumns = @JoinColumn(name = "movel_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_quarto_id"))
    private List<TipoQuartoEntity> tipoQuartoEntities;

    public MovelEntity(){
    }

    public MovelEntity(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public MovelEntity(Long id, String nome, List<TipoQuartoEntity> tipoQuartoEntities){
        this.id = id;
        this.nome = nome;
        this.tipoQuartoEntities = tipoQuartoEntities;
    }

    public MovelEntity(Movel movel) {
        this.id = movel.getId();
        this.nome = movel.getNome();
    }

    public Movel toEntity() {
        return new Movel(this.id, this.nome);
    }

    public Movel toEntityWithTipoQuarto() {
        return new Movel(
                this.id,
                this.nome,
                this.tipoQuartoEntities.stream().map(TipoQuartoEntity::toEntity).toList()
        );
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<TipoQuartoEntity> getTipoQuartoEntities(){
        return tipoQuartoEntities;
    }

    public void setTipoQuartoEntities(List<TipoQuartoEntity> tipoQuartoEntities){
        this.tipoQuartoEntities = tipoQuartoEntities;
    }
}
