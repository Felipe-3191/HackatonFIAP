package com.fiap.Hackaton.infraestructure.cliente.repository;

import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
}
