package com.fiap.Hackaton.infraestructure.tipoquarto.entityschema;

import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.infraestructure.movel.entityschema.MovelEntity;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipo_quarto")
public class TipoQuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTipo;
    private Integer capacidadeTotal;
    private String quantidadeCamas;
    private String banheiro;


    @ManyToMany
    @JoinTable(
            name = "tipo_quarto_movel",
            joinColumns = @JoinColumn(name = "tipo_quarto_id"),
            inverseJoinColumns = @JoinColumn(name = "movel_id"))
    private List<MovelEntity> movelEntities;

    @OneToMany
    @JoinColumn(name = "tipo_quarto_id")
    private List<QuartoEntity> quartoEntities;

    public TipoQuartoEntity() {
    }

    public TipoQuartoEntity(Long id, String nomeTipo, Integer capacidadeTotal, String quantidadeCamas, String banheiro) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
    }

    public TipoQuartoEntity(TipoQuarto tipoQuarto) {
        this.id = tipoQuarto.getId();
        this.nomeTipo = tipoQuarto.getNomeTipo();
        ;
        this.capacidadeTotal = tipoQuarto.getCapacidadeTotal();
        this.quantidadeCamas = tipoQuarto.getQuantidadeCamas();
    }

    public static List<TipoQuarto> toTipoQuartoList(List<TipoQuartoEntity> listTipoQuartoEntity) {
        return listTipoQuartoEntity.stream().map(TipoQuartoEntity::toEntity).toList();
    }

    public TipoQuarto toEntity() {
        return new TipoQuarto(
                this.id,
                this.nomeTipo,
                this.capacidadeTotal,
                this.quantidadeCamas,
                this.banheiro
        );
    }

    public TipoQuarto toEntityWithMoveis() {

        if (this.movelEntities != null) {
            return new TipoQuarto(
                    this.id,
                    this.nomeTipo,
                    this.capacidadeTotal,
                    this.quantidadeCamas,
                    this.banheiro,
                    this.movelEntities.stream().map(MovelEntity::toEntity).toList()
            );
        } else {
            return this.toEntity();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(String quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public String getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(String banheiro) {
        this.banheiro = banheiro;
    }

}