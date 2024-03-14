package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.exception.CpfObrigatorioException;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AtualizarClienteUseCaseTest {

    private ClienteGateway clienteGateway;
    private AtualizarClienteUseCase atualizarClienteUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        atualizarClienteUseCase = new AtualizarClienteUseCase(clienteGateway);
    }

    @Test
    public void testExecuteReturnsUpdatedCliente() {
        // Arrange
        Long id = 1L;
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Cliente clienteOriginal = new Cliente();
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.of(clienteOriginal));
        Cliente clienteAtualizado = new Cliente();
        when(clienteGateway.atualizar(Mockito.any(Cliente.class))).thenReturn(clienteAtualizado);

        // Act
        Cliente result = atualizarClienteUseCase.execute(id, dados);

        // Assert
        assertNotNull(result);
        assertEquals(clienteAtualizado, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> atualizarClienteUseCase.execute(id, dados));
    }

    @Test
    public void testExecuteThrowsCpfObrigatorioException() {
        // Arrange
        Long id = 1L;
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn(null);
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.of(new Cliente()));

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> atualizarClienteUseCase.execute(id, dados));
    }

    @Test
    public void testExecuteThrowsPassaporteObrigatorioException() {
        // Arrange
        Long id = 1L;
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("USA");
        when(dados.passaporte()).thenReturn(null);
        when(clienteGateway.buscarPorId(id)).thenReturn(Optional.of(new Cliente()));

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> atualizarClienteUseCase.execute(id, dados));
    }
}
