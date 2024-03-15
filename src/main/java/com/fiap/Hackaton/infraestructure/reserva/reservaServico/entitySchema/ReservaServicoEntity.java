package com.fiap.Hackaton.infraestructure.reserva.reservaServico.entitySchema;

import com.fiap.Hackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva_servico")
public class ReservaServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reservaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    private ServicoEntity servicoEntity;

    public ReservaServicoEntity() {
    }
    public ReservaServicoEntity(Long id, Integer quantidade, ReservaEntity reservaEntity, ServicoEntity servicoEntity) {
        this.id = id;
        this.quantidade = quantidade;
        this.reservaEntity = reservaEntity;
        this.servicoEntity = servicoEntity;
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

    public ServicoEntity getServicoEntity() {
        return servicoEntity;
    }

    public void setServicoEntity(ServicoEntity servicoEntity) {
        this.servicoEntity = servicoEntity;
    }
}
