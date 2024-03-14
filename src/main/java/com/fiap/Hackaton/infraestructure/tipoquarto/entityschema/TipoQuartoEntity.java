package com.fiap.Hackaton.infraestructure.tipoquarto.entityschema;

import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.infraestructure.movel.entityschema.MovelEntity;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tipo_quarto")
public class TipoQuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTipo;
    private Integer capacidadeTotal;
    private Integer quantidadeCamas;

    @ManyToMany
    @JoinTable(
            name = "tipo_quarto_movel",
            joinColumns = @JoinColumn(name = "movel_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_quarto_id"))
    private List<MovelEntity> movelEntities;

    @OneToMany
    @JoinColumn(name = "tipo_quarto_id")
    private List<QuartoEntity> quartoEntities;

    public TipoQuartoEntity(){
    }

    public TipoQuartoEntity(Long id, String nomeTipo, Integer capacidadeTotal, Integer quantidadeCamas){
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
    }

    public TipoQuartoEntity(TipoQuarto tipoQuarto) {
        this.id = tipoQuarto.getId();
        this.nomeTipo = tipoQuarto.getNomeTipo();;
        this.capacidadeTotal = tipoQuarto.getCapacidadeTotal();
        this.quantidadeCamas = tipoQuarto.getQuantidadeCamas();
    }

    public TipoQuarto toEntity() {
        return new TipoQuarto(
                this.id,
                this.nomeTipo,
                this.capacidadeTotal,
                this.quantidadeCamas
        );
    }

    public TipoQuarto toEntityWithMoveis() {
        return new TipoQuarto(
                this.id,
                this.nomeTipo,
                this.capacidadeTotal,
                this.quantidadeCamas,
                this.movelEntities.stream().map(MovelEntity::toEntity).toList()
        );
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomeTipo(){
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo){
        this.nomeTipo = nomeTipo;
    }

    public Integer getCapacidadeTotal(){
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal){
        this.capacidadeTotal = capacidadeTotal;
    }

    public Integer getQuantidadeCamas(){
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(Integer quantidadeCamas){
        this.quantidadeCamas = quantidadeCamas;
    }
}
