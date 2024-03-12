package com.fiap.Hackaton.infraestructure.cliente.repository;

import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
