package com.fiap.Hackaton.infraestructure.reserva.gateway;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import com.fiap.Hackaton.infraestructure.reserva.repository.ReservaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservaDatabaseGateway implements ReservaGateway {

    private final ReservaRepository repository;

    public ReservaDatabaseGateway(ReservaRepository repository){
        this.repository = repository;
    }

    @Override
    public Reserva criar(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity(reserva);
        return repository.save(reservaEntity).toEntity();
    }

    @Override
    public void deletar(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity(reserva);
        repository.delete(reservaEntity);
    }

    @Override
    public List<Reserva> listarPorCliente(String cpf){
        return repository.findByCliente_Cpf(cpf).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarPorHotel(Long idHotel){
        return repository.findByHotel_Id(idHotel).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarPorPeriodo(LocalDate inicio, LocalDate fim){
        return repository.findByDataReservaBetween(inicio, fim).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id){
        try {
            return repository.findById(id).map(ReservaEntity::toEntity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido");
        }
    }

    @Override
    public void removerQuartoDeReservas(QuartoEntity quarto){
        List<ReservaEntity> reservaEntities = repository.findAll();
        reservaEntities.forEach(reservaEntity -> {
            reservaEntity.getQuartoEntity().removeIf(quartoEntity -> quartoEntity.getId().equals(quarto.getId()));
            repository.save(reservaEntity);
        });
    }


    @Override
    public void removerClienteDeReserva(Cliente cliente){
        repository.findAll().stream()
                .filter(reservaEntity -> reservaEntity.getCliente().getId().equals(cliente.getId()))
                .forEach(repository::delete);
    }
    @Override
    public Reserva reservar(Reserva reserva) {
        ReservaEntity reservaEntity = new ReservaEntity(reserva.getResponsavelReserva(), reserva.getDataInicial(),
                reserva.getDataFinal(), reserva.getQuantidadePessoas(),
                reserva.getValorReserva(), reserva.getValorTotal(),
                reserva.getQuartosReservados(),
                reserva.getServicosConsumidos(), reserva.getItensConsumidos());

        return repository.save(reservaEntity).toEntityReservar();

    }
}
