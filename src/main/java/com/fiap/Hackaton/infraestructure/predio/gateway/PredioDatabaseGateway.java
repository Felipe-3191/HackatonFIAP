package com.fiap.Hackaton.infraestructure.predio.gateway;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.infraestructure.predio.entityschema.PredioEntity;
import com.fiap.Hackaton.infraestructure.predio.repository.PredioRepository;
import com.fiap.Hackaton.infraestructure.quarto.entitySchema.QuartoEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PredioDatabaseGateway implements PredioGateway {

    private final PredioRepository repository;

    public PredioDatabaseGateway(PredioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Predio criar(Predio predio) {
        PredioEntity predioEntity = new PredioEntity(predio);

        return repository.save(predioEntity).toSimpleEntity();
    }

    @Override
    public Predio atualizar(Predio predio) {
        PredioEntity predioEntity = new PredioEntity(predio);
        predioEntity.setQuartoEntities(predio.getQuartos().stream().map(QuartoEntity::new).collect(Collectors.toList()));
        return repository.save(predioEntity).toSimpleEntity();
    }

    @Override
    public List<Predio> listar() {
        return this.repository.findAll().stream().map(PredioEntity::toEntityWithQuartos).collect(Collectors.toList());
    }

    @Override
    public Optional<Predio> buscarPorId(Long id) {
        return this.repository.findById(id).map(PredioEntity::toEntityWithQuartos);
    }

    @Override
    public Optional<List<Predio>> buscarPorNome(String nome) {
        return this.repository.findByNome(nome).map(
                predioEntities -> predioEntities.stream().map(PredioEntity::toEntityWithQuartos).collect(Collectors.toList())
        );
    }

    @Override
    public void deletar(Predio predio) {

        PredioEntity predioEntity = new PredioEntity(predio);
        this.repository.delete(predioEntity);

    }
}
