package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarClienteUseCaseTest {

    private ClienteGateway clienteGateway;
    private DeletarClienteUseCase deletarClienteUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        deletarClienteUseCase = new DeletarClienteUseCase(clienteGateway);
    }

    @Test
    public void testExecuteDeletesCliente() {
        // Arrange
        Long id = 1L;
        Cliente cliente = new Cliente();
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.of(cliente));

        // Act
        deletarClienteUseCase.execute(id);

        // Assert
        verify(clienteGateway, times(1)).deletar(cliente);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> deletarClienteUseCase.execute(id));
    }
}
