package com.fiap.Hackaton.infraestructure.cliente.gateway;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteDatabaseGatewayTest {

    @Mock
    private ClienteRepository repository;

    private ClienteDatabaseGateway gateway;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gateway = new ClienteDatabaseGateway(repository);
    }

    @Test
    public void testCriar() {

        Cliente cliente = new Cliente();
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        when(repository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        Cliente result = gateway.criar(cliente);

        assertEquals(cliente.getId(), result.getId());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
        verify(repository, times(1)).save(clienteEntity);
    }

    @Test
    public void testAtualizar() {

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        when(repository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
        when(repository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        Cliente result = gateway.atualizar(cliente);

        assertEquals(cliente.getId(), result.getId());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
        verify(repository, times(1)).findById(cliente.getId());
        verify(repository, times(1)).save(clienteEntity);
    }

    @Test
    public void testListar() {
        // Arrange
        ClienteEntity clienteEntity = new ClienteEntity(new Cliente());
        List<ClienteEntity> clienteEntities = Arrays.asList(clienteEntity);
        when(repository.findAll()).thenReturn(clienteEntities);

        // Act
        List<Cliente> result = gateway.listar();

        // Assert
        assertEquals(clienteEntities.size(), result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        when(repository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));

        // Act
        Optional<Cliente> result = gateway.buscarPorId(cliente.getId());

        // Assert
        assertEquals(cliente.getId(), result.get().getId());
        verify(repository, times(1)).findById(cliente.getId());
    }

    @Test
    public void testBuscarPorCpf() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        when(repository.findByCpf(anyString())).thenReturn(Optional.of(clienteEntity));

        // Act
        Optional<Cliente> result = gateway.buscarPorCpf(cliente.getCpf());

        // Assert
        assertEquals(cliente.getCpf(), result.get().getCpf());
        verify(repository, times(1)).findByCpf(cliente.getCpf());
    }

    @Test
    public void testDeletar() {
        // Arrange
        Cliente cliente = new Cliente();
        ClienteEntity clienteEntity = new ClienteEntity(cliente);

        // Act
        gateway.deletar(cliente);

        // Assert
        verify(repository, times(1)).delete(clienteEntity);
    }
}
