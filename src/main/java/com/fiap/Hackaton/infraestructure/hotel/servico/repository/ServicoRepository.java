package com.fiap.Hackaton.infraestructure.hotel.servico.repository;

import com.fiap.Hackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
}
