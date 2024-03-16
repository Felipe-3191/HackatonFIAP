package com.fiap.Hackaton.domain.reserva.gateway;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaGateway {

    Reserva criar(Reserva reserva);
    void deletar(Reserva reserva);
    List<Reserva> listarPorCliente(String cpf);
    List<Reserva> listarPorHotel(Long idHotel);

    List<Reserva> listarPorPeriodo(LocalDate inicio, LocalDate fim);

    Optional<Reserva> buscarPorId(Long id);

    void removerQuartoDeReservas(QuartoEntity quarto);

    void removerClienteDeReserva(Cliente cliente);
}
