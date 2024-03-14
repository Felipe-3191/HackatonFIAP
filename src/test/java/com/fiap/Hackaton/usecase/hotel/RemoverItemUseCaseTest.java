package com.fiap.Hackaton.usecase.hotel;

import com.fiap.Hackaton.domain.hotel.entity.Hotel;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.usecase.item.BuscarItemUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RemoverItemUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    @Mock
    private BuscarItemUseCase buscarItemUseCase;

    private RemoverItemUseCase removerItemUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        removerItemUseCase = new RemoverItemUseCase(hotelGateway, buscarItemUseCase);
    }

    @Test
    public void shouldRemoveItemWhenHotelAndItemExist() {
        Hotel hotel = new Hotel();
        Item item = new Item();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));
        when(buscarItemUseCase.execute(anyLong())).thenReturn(item);
        when(hotelGateway.removerItem(hotel)).thenReturn(hotel);

        Hotel result = removerItemUseCase.executar(1L, 1L);

        assertEquals(hotel, result);
    }

    @Test
    public void shouldThrowExceptionWhenHotelDoesNotExist() {
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> removerItemUseCase.executar(1L, 1L));
    }

    @Test
    public void shouldThrowExceptionWhenItemDoesNotExist() {
        Hotel hotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));
        when(buscarItemUseCase.execute(anyLong())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> removerItemUseCase.executar(1L, 1L));
    }
}