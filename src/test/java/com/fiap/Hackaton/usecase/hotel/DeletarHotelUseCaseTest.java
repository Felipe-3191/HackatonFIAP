package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarHotelUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private DeletarHotelUseCase deletarHotelUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarHotelUseCase = new DeletarHotelUseCase(hotelGateway);
    }

    @Test
    public void shouldDeleteHotelWhenIdExists() {
        Hotel hotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));

        deletarHotelUseCase.executar(1L);

        verify(hotelGateway, times(1)).deletar(hotel);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deletarHotelUseCase.executar(1L));
    }
}