package com.fiap.Hackaton.infraestructure.quarto.controller;

import com.fiap.Hackaton.domain.predio.entity.Predio;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.entity.Status;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorIdUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarQuartoPorIdControllerTest {

    private final BuscarQuartoPorIdUseCase useCase = Mockito.mock(BuscarQuartoPorIdUseCase.class);
    private final BuscarQuartoPorIdController controller = new BuscarQuartoPorIdController(useCase);

    @Test
    public void shouldReturnQuartoWhenIdExists() {
        Quarto quarto = mock(Quarto.class);
        TipoQuarto tipoQuarto = mock(TipoQuarto.class);
        Predio predio = mock(Predio.class);

        when(quarto.getTipoQuarto()).thenReturn(tipoQuarto);
        when(quarto.getPredio()).thenReturn(predio);
        when(quarto.getIdHotel()).thenReturn(1L);
        when(quarto.getValorDiaria()).thenReturn(new BigDecimal(100.00));
        when(quarto.getStatus()).thenReturn(Status.DISPONIVEL);
        when(quarto.getId()).thenReturn(1L);
        when(tipoQuarto.getId()).thenReturn(1L);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Predio 1");

        when(useCase.execute(1L)).thenReturn(quarto);

        ResponseEntity<QuartoSearchResponseData> response = controller.buscarQuarto(1L);

        assertEquals(200, response.getStatusCodeValue());
    }
}