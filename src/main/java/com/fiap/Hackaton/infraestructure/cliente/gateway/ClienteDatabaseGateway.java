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
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("Cliente ID não pode ser nulo ao atualizar");
        }
        Optional<ClienteEntity> optionalClienteEntity = repository.findById(cliente.getId());
        if (optionalClienteEntity.isEmpty()) {
            throw new IllegalArgumentException("Cliente com ID " + cliente.getId() + " não encontrado");
        }
        ClienteEntity encontrado = optionalClienteEntity.get();
        encontrado.setNome(cliente.getNome());
        encontrado.setCpf(cliente.getCpf());
        encontrado.setEmail(cliente.getEmail());
        encontrado.setDataNascimento(cliente.getDataNascimento());
        encontrado.setPassaporte(cliente.getPassaporte());
        encontrado.setPaisOrigem(cliente.getPaisOrigem());
        encontrado.setTelefone(cliente.getTelefone());
        encontrado.setEnderecoPaisOrigem(cliente.getEnderecoPaisOrigem());
        return repository.save(encontrado).toCliente();
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
    public Optional<Cliente> buscarPorCpf(String cpf){
        return repository.findByCpf(cpf).map(ClienteEntity::toCliente);
    }

    @Override
    public void deletar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
         repository.delete(clienteEntity);
    }


}
