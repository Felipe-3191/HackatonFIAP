package com.fiap.Hackaton.infraestructure.reserva.entitySchema;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaItem.entitySchema.ReservaItemEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.entitySchema.ReservaServicoEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean confirmada;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private BigDecimal valorReserva;
    private BigDecimal valorTotal;
    private Integer quantidadePessoas;
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.PERSIST)
    private List<ReservaServicoEntity> reservaServicoEntities;
    @OneToMany(mappedBy = "reserva" , cascade = CascadeType.PERSIST)
    private List<ReservaItemEntity> reservaItemEntities;

    @ManyToMany
    @JoinTable(
            name = "reserva_quarto",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "quarto_id"))
    private List<QuartoEntity> quartoEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


    public ReservaEntity() {
    }
    public ReservaEntity(Long id, LocalDate dataInicial, LocalDate dataFinal, Long valorReserva, Long valorTotal, Integer quantidadePessoas, List<ReservaServicoEntity> reservaServicoEntities, List<ReservaItemEntity> reservaItemEntities, ClienteEntity cliente) {
        this.id = id;
        dataInicial = dataInicial;
        dataFinal = dataFinal;
        valorReserva = valorReserva;
        valorTotal = valorTotal;
        quantidadePessoas = quantidadePessoas;
        this.reservaServicoEntities = reservaServicoEntities;
        this.reservaItemEntities = reservaItemEntities;
        this.cliente = cliente;
    }

    public ReservaEntity(Reserva reserva) {
        this.id = reserva.getId();
        this.dataInicial = reserva.getDataInicial();
        this.dataFinal = reserva.getDataFinal();
        this.valorReserva = reserva.getValorReserva();
        this.valorTotal = reserva.getValorTotal();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.cliente = new ClienteEntity(reserva.getResponsavelReserva());
        this.reservaServicoEntities = reserva.getServicosConsumidos().stream().map(ReservaServicoEntity::new).toList();
        this.reservaItemEntities = reserva.getItensConsumidos().stream().map(ReservaItemEntity::new).toList();
    }

    public ReservaEntity(Cliente cliente, LocalDate dataInicial, LocalDate dataFinal, Integer quantidadePessoas,
                         BigDecimal valorReserva, BigDecimal valorTotal,
                         List<Quarto> quartos, List<ReservaServico> servicos, List<ReservaItem> itens) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorReserva = valorReserva;
        this.valorTotal = valorTotal;
        this.quantidadePessoas = quantidadePessoas;
        this.cliente = new ClienteEntity(cliente);
        this.quartoEntities = quartos.stream().map(QuartoEntity::new).toList();
        this.reservaServicoEntities = servicos.stream().map(ReservaServicoEntity::new).toList();
        this.reservaItemEntities = itens.stream().map(ReservaItemEntity::new).toList();
    }
    public Boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(Boolean confirmada) {
        this.confirmada = confirmada;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<QuartoEntity> getQuartoEntities() {
        return quartoEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        dataFinal = dataFinal;
    }

    public BigDecimal getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(BigDecimal valorReserva) {
        valorReserva = valorReserva;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        valorTotal = valorTotal;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        quantidadePessoas = quantidadePessoas;
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

    public Reserva toEntity(){
        return new Reserva(
                this.id,
                this.dataInicial,
                this.dataFinal,
                this.valorReserva,
                this.valorTotal,
                this.quantidadePessoas,
                this.cliente.toEntity(),
                this.quartoEntities.stream().map(QuartoEntity::toEntity).toList()
        );
    }

    public Reserva toEntityReservar(){
        return new Reserva(
                this.id,
                this.dataInicial,
                this.dataFinal,
                this.valorReserva,
                this.valorTotal,
                this.quantidadePessoas,
                this.cliente.toEntity(),
                this.quartoEntities.stream().map(QuartoEntity::toEntity).toList(),
                this.reservaItemEntities.stream().map(ReservaItemEntity::toEntity).toList(),
                this.reservaServicoEntities.stream().map(ReservaServicoEntity::toEntity).toList()

        );
    }

}
