package com.fiap.Hackaton.infraestructure.quarto.entitySchema;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.infraestructure.predio.entityschema.PredioEntity;
import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import com.fiap.Hackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "quarto")
public class QuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "predio_id")
    private PredioEntity predio;
    private Long idHotel;
    private BigDecimal valorDiaria;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "tipo_quarto_id")
    private TipoQuartoEntity tipoQuarto;


    public QuartoEntity() {
    }

    public QuartoEntity(Long id, PredioEntity predio, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuartoEntity tipoQuarto) {
        this.id = id;
        this.predio = predio;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public QuartoEntity(Quarto quarto) {
        this.id = quarto.getId();
        if(quarto.getPredio() != null)
            this.predio = new PredioEntity(quarto.getPredio());
        if(quarto.getIdHotel() != null)
            this.idHotel = quarto.getIdHotel();
        this.valorDiaria = quarto.getValorDiaria();
        this.status = quarto.getStatus();
        if(quarto.getTipoQuarto() != null)
            this.tipoQuarto = new TipoQuartoEntity(quarto.getTipoQuarto());
    }

    public PredioEntity getPredio() {
        return predio;
    }

    public void setPredio(PredioEntity predio) {
        this.predio = predio;
    }

    public Quarto toEntity() {
        return new Quarto(
                this.id,
                this.getPredio() != null ? this.getPredio().toEntity() : null,
                this.idHotel,
                this.valorDiaria,
                this.status,
                this.tipoQuarto != null ? this.tipoQuarto.toEntity() : null
        );


    }

    public Quarto toEntityToPredio(){
        return new Quarto(
                this.id,
                this.valorDiaria,
                this.status,
                this.tipoQuarto.toEntityWithMoveis()
        );
    }

    public Quarto toSimpleEntity() {
        return new Quarto(
                this.id,
                this.idHotel,
                this.valorDiaria,
                this.status,
                this.tipoQuarto.toEntity()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PredioEntity getIdPredio() {
        return predio;
    }

    public void setIdPredio(PredioEntity predio) {
        this.predio = predio;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoQuartoEntity getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuartoEntity tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
}
