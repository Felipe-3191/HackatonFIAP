package com.fiap.Hackaton.infraestructure.cliente.gateway;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteDatabaseGateway implements ClienteGateway {

    private final ClienteRepository repository;

    public ClienteDatabaseGateway(ClienteRepository repository) {
        this.repository = repository;
    }


    @Override
    public Cliente criar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        return repository.save(clienteEntity).toCliente();
    }


    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        return repository.save(clienteEntity).toCliente();
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll().stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id).map(ClienteEntity::toCliente);
    }

    @Override
    public void deletar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
         repository.delete(clienteEntity);
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf){
        return Optional.empty();
    }
}
