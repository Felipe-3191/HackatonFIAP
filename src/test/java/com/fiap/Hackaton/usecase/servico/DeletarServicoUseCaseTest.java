package com.fiap.Hackaton.usecase.servico;

import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeletarServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    private DeletarServicoUseCase deletarServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarServicoUseCase = new DeletarServicoUseCase(servicoGateway);
    }

    @Test
    public void shouldDeleteServiceWhenServiceExists() {
        Servico servico = new Servico();
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.of(servico));

        deletarServicoUseCase.execute(1L);

        verify(servicoGateway).deletar(servico);
    }

    @Test
    public void shouldThrowExceptionWhenServiceDoesNotExist() {
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> deletarServicoUseCase.execute(1L));
    }
}