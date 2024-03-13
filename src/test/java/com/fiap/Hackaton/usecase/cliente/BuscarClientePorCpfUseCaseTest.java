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

public class BuscarClientePorCpfUseCaseTest {

    private ClienteGateway clienteGateway;
    private BuscarClientePorCpfUseCase buscarClientePorCpfUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        buscarClientePorCpfUseCase = new BuscarClientePorCpfUseCase(clienteGateway);
    }

    @Test
    public void testExecuteReturnsCliente() {
        // Arrange
        String cpf = "12345678901";
        Cliente cliente = new Cliente();
        when(clienteGateway.buscarPorCpf(cpf)).thenReturn(Optional.of(cliente));

        // Act
        Cliente result = buscarClientePorCpfUseCase.execute(cpf);

        // Assert
        assertNotNull(result);
        assertEquals(cliente, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        String cpf = "12345678901";
        when(clienteGateway.buscarPorCpf(cpf)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> buscarClientePorCpfUseCase.execute(cpf));
    }
}
