package com.fiap.Hackaton.infraestructure.quarto.repository;

import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.Hackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuartoRepository extends JpaRepository<QuartoEntity, Long> {
    //List<QuartoEntity> findByQtdHospedes(Long qtdHospedes);
    List<QuartoEntity> findByTipoQuarto(TipoQuartoEntity tipoQuarto);
}
