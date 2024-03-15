package com.fiap.Hackaton.infraestructure.reserva.reservaServico.entitySchema;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
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
    private ReservaEntity reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    private ServicoEntity servico;

    public ReservaServicoEntity() {
    }
    public ReservaServicoEntity(Long id, Integer quantidade, ReservaEntity reserva, ServicoEntity servico) {
        this.id = id;
        this.quantidade = quantidade;
        this.reserva = reserva;
        this.servico = servico;
    }

    public ReservaServicoEntity(ReservaServico reservaServico){
        this.id = reservaServico.getId();
        this.quantidade = reservaServico.getQuantidade();
        if(reservaServico.getReserva() != null)
            this.reserva = new ReservaEntity(reservaServico.getReserva());
        if(reservaServico.getServico() != null)
            this.servico = new ServicoEntity(reservaServico.getServico());

    }
    public ReservaServicoEntity(Servico servico){
        this.servico = new ServicoEntity(servico);
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

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
    }
}
