package com.fiap.Hackaton.infraestructure.hotel.item.gateway;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.Hackaton.infraestructure.hotel.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemDatabaseGateway implements ItemGateway {

    private final ItemRepository repository;

    public ItemDatabaseGateway(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item criar(Item item) {
        ItemEntity itemEntity = new ItemEntity(item);
        return repository.save(itemEntity).toItem();
    }

    @Override
    public Item atualizar(Item item) {
        if (item.getId() == null) {
            throw new IllegalArgumentException("Item ID não pode ser nulo ao atualizar");
        }
        Optional<ItemEntity> optionalItemEntity = repository.findById(item.getId());
        if (optionalItemEntity.isEmpty()) {
            throw new IllegalArgumentException("Item com ID " + item.getId() + " não encontrado");
        }
        ItemEntity encontrado = optionalItemEntity.get();
        encontrado.setNome(item.getNome());
        encontrado.setValor(item.getValor());
        return repository.save(encontrado).toItem();
    }

    @Override
    public List<Item> listar() {
        return repository.findAll().stream().map(ItemEntity::toItem).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> buscarPorId(Long id) {
        Optional<ItemEntity> optionalItemEntity = repository.findById(id);
        if (optionalItemEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(optionalItemEntity.get().toItem());
    }

    @Override
    public void deletar(Item item) {
        ItemEntity itemEntity = new ItemEntity(item);
        repository.delete(itemEntity);
    }
}