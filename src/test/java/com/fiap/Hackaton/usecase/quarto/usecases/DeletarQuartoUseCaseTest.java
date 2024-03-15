package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarQuartoUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;

    private DeletarQuartoUseCase deletarQuartoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarQuartoUseCase = new DeletarQuartoUseCase(quartoGateway);
    }

    @Test
    public void shouldDeleteRoomWhenRoomExists() {
        Quarto quarto = new Quarto();
        when(quartoGateway.buscarPorId(1L)).thenReturn(Optional.of(quarto));

        deletarQuartoUseCase.executar(1L);

        verify(quartoGateway, times(1)).deletar(quarto);
    }

    @Test
    public void shouldThrowExceptionWhenRoomDoesNotExist() {
        when(quartoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> deletarQuartoUseCase.executar(1L));

        verify(quartoGateway, never()).deletar(any());
    }
}