package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BuscarClienteUseCaseTest {

    private ClienteGateway clienteGateway;
    private BuscarClienteUseCase buscarClienteUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        buscarClienteUseCase = new BuscarClienteUseCase(clienteGateway);
    }

    @Test
    public void testExecuteReturnsCliente() {
        // Arrange
        Long id = 1L;
        Cliente cliente = new Cliente();
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.of(cliente));

        // Act
        Cliente result = buscarClienteUseCase.execute(id);

        // Assert
        assertNotNull(result);
        assertEquals(cliente, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> buscarClienteUseCase.execute(id));
    }
}
