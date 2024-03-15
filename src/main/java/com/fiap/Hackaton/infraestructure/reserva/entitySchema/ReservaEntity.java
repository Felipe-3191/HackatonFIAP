package com.fiap.Hackaton.infraestructure.reserva.entitySchema;

import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaItem.entitySchema.ReservaItemEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.entitySchema.ReservaServicoEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate DataInicial;
    private LocalDate DataFinal;
    private Long ValorReserva;
    private Long ValorTotal;
    private Integer QuantidadePessoas;
    @OneToMany(mappedBy = "reserva")
    private List<ReservaServicoEntity> reservaServicoEntities;
    @OneToMany(mappedBy = "reserva")
    private List<ReservaItemEntity> reservaItemEntities;
    @ManyToMany
    @JoinTable(
            name = "reserva_quarto",
            joinColumns = @JoinColumn(name = "quarto_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id"))
    private List<QuartoEntity> quartoEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


    public ReservaEntity() {
    }
    public ReservaEntity(Long id, LocalDate dataInicial, LocalDate dataFinal, Long valorReserva, Long valorTotal, Integer quantidadePessoas, List<ReservaServicoEntity> reservaServicoEntities, List<ReservaItemEntity> reservaItemEntities, ClienteEntity cliente) {
        this.id = id;
        DataInicial = dataInicial;
        DataFinal = dataFinal;
        ValorReserva = valorReserva;
        ValorTotal = valorTotal;
        QuantidadePessoas = quantidadePessoas;
        this.reservaServicoEntities = reservaServicoEntities;
        this.reservaItemEntities = reservaItemEntities;
        this.cliente = cliente;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return DataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        DataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return DataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        DataFinal = dataFinal;
    }

    public Long getValorReserva() {
        return ValorReserva;
    }

    public void setValorReserva(Long valorReserva) {
        ValorReserva = valorReserva;
    }

    public Long getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        ValorTotal = valorTotal;
    }

    public Integer getQuantidadePessoas() {
        return QuantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        QuantidadePessoas = quantidadePessoas;
    }

    public List<ReservaServicoEntity> getReservaServicoEntities() {
        return reservaServicoEntities;
    }

    public void setReservaServicoEntities(List<ReservaServicoEntity> reservaServicoEntities) {
        this.reservaServicoEntities = reservaServicoEntities;
    }

    public List<ReservaItemEntity> getReservaItemEntities() {
        return reservaItemEntities;
    }

    public void setReservaItemEntities(List<ReservaItemEntity> reservaItemEntities) {
        this.reservaItemEntities = reservaItemEntities;
    }

    public List<QuartoEntity> getQuartoEntity() {
        return quartoEntities;
    }

    public void setQuartoEntities(List<QuartoEntity> quartoEntities) {
        this.quartoEntities = quartoEntities;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
