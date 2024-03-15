package com.fiap.Hackaton.usecase.quarto.usecases;

import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarTodosQuartosUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;

    private BuscarTodosQuartosUseCase buscarTodosQuartosUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosQuartosUseCase = new BuscarTodosQuartosUseCase(quartoGateway);
    }

    @Test
    public void shouldReturnAllRoomsWhenRoomsExist() {
        Quarto quarto = new Quarto();
        when(quartoGateway.listar()).thenReturn(Arrays.asList(quarto));

        List<Quarto> result = buscarTodosQuartosUseCase.execute();

        assertEquals(Arrays.asList(quarto), result);
    }

    @Test
    public void shouldReturnEmptyListWhenNoRoomsExist() {
        when(quartoGateway.listar()).thenReturn(Arrays.asList());

        List<Quarto> result = buscarTodosQuartosUseCase.execute();

        assertEquals(Arrays.asList(), result);
    }
}