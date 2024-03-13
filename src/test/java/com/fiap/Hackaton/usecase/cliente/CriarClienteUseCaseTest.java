package com.fiap.Hackaton.usecase.cliente;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.cliente.exception.CpfJaCadastradoException;
import com.fiap.Hackaton.domain.cliente.exception.CpfObrigatorioException;
import com.fiap.Hackaton.domain.cliente.exception.PassaporteObrigatorioException;
import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.usecase.cliente.dto.IClienteRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CriarClienteUseCaseTest {

    private ClienteGateway clienteGateway;
    private CriarClienteUseCase criarClienteUseCase;

    @BeforeEach
    public void setUp() {
        clienteGateway = Mockito.mock(ClienteGateway.class);
        criarClienteUseCase = new CriarClienteUseCase(clienteGateway);
    }

    @Test
    public void testExecutarReturnsCliente() {
        // Arrange
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Cliente cliente = new Cliente();
        when(clienteGateway.criar(Mockito.any(Cliente.class))).thenReturn(cliente);

        // Act
        Cliente result = criarClienteUseCase.executar(dados);

        // Assert
        assertNotNull(result);
        assertEquals(cliente, result);
    }

    @Test
    public void testExecutarThrowsCpfObrigatorioException() {
        // Arrange
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn(null);

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> criarClienteUseCase.executar(dados));
    }

    @Test
    public void testExecutarThrowsPassaporteObrigatorioException() {
        // Arrange
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("USA");
        when(dados.passaporte()).thenReturn(null);

        // Act & Assert
        assertThrows(PassaporteObrigatorioException.class, () -> criarClienteUseCase.executar(dados));
    }

    @Test
    public void testExecutarThrowsCpfJaCadastradoException() {
        // Arrange
        IClienteRequestData dados = Mockito.mock(IClienteRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Cliente cliente = new Cliente();
        when(clienteGateway.buscarPorCpf(dados.cpf())).thenReturn(Optional.of(cliente));

        // Act & Assert
        assertThrows(CpfJaCadastradoException.class, () -> criarClienteUseCase.executar(dados));
    }
}
