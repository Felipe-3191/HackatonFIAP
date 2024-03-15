package com.fiap.Hackaton.infraestructure.reserva.repository;

import com.fiap.Hackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository  extends JpaRepository<ReservaEntity, Long> {

}
