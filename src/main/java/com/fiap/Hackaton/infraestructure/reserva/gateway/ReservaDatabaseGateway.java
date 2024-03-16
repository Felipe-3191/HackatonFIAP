package com.fiap.Hackaton.infraestructure.reserva.gateway;

import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import com.fiap.Hackaton.infraestructure.reserva.repository.ReservaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaDatabaseGateway implements ReservaGateway {

    private final ReservaRepository repository;

    public ReservaDatabaseGateway(ReservaRepository repository) {
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
    public Reserva reservar(Reserva reserva) {
        ReservaEntity reservaEntity = new ReservaEntity(reserva.getResponsavelReserva(), reserva.getDataInicial(), reserva.getDataFinal(),
                reserva.getQuantidadePessoas(), reserva.getQuartosReservados(), reserva.getServicosConsumidos(), reserva.getItensConsumidos());
        return repository.save(reservaEntity).toEntity();
    }

}
