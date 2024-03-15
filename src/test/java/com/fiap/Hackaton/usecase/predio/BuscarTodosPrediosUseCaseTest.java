package com.fiap.Hackaton.usecase.predio;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class BuscarTodosPrediosUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private BuscarTodosPrediosUseCase buscarTodosPrediosUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosPrediosUseCase = new BuscarTodosPrediosUseCase(predioGateway);
    }

    @Test
    public void shouldReturnAllBuildingsWhenTheyExist() {
        List<Predio> predios = Collections.singletonList(new Predio());
        when(predioGateway.listar()).thenReturn(predios);

        List<Predio> result = buscarTodosPrediosUseCase.executar();

        assertEquals(predios, result);
    }

    @Test
    public void shouldReturnEmptyListWhenNoBuildingsExist() {
        when(predioGateway.listar()).thenReturn(Collections.emptyList());

        List<Predio> result = buscarTodosPrediosUseCase.executar();

        assertTrue(result.isEmpty());
    }
}