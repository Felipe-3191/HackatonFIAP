package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class BuscarTodosClientesUseCaseTest {

    private ClienteGateway clienteGateway;
    private BuscarTodosClientesUseCase buscarTodosClientesUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        buscarTodosClientesUseCase = new BuscarTodosClientesUseCase(clienteGateway);
    }

    @Test
    public void testExecuteReturnsAllClientes() {
        // Arrange
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        when(clienteGateway.listar()).thenReturn(clientes);

        // Act
        List<Cliente> result = buscarTodosClientesUseCase.execute();

        // Assert
        assertNotNull(result);
        assertEquals(clientes, result);
    }
}
