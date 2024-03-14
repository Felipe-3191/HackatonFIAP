package com.fiap.Hackaton.infraestructure.tipoquarto.repository;

import com.fiap.Hackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoQuartoRepository extends JpaRepository<TipoQuartoEntity, Long> {
    List<TipoQuartoEntity> findByCapacidadeTotalLessThanEqual(Long capacidadeTotal);
}
