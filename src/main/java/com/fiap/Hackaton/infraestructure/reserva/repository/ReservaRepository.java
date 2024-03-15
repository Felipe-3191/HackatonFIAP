package com.fiap.Hackaton.infraestructure.reserva.repository;

import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository  extends JpaRepository<ReservaEntity, Long> {

    List<ReservaEntity> findByHotel_Id(Long hotelId);
    List<ReservaEntity> findByCliente_Id(Long clienteId);
    List<ReservaEntity> findByDataReservaBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<ReservaEntity> findByCliente_Cpf(String cpf);
}
