package com.fiap.Hackaton.infraestructure.reserva.reservaItem.dto;

import com.fiap.Hackaton.usecase.reserva.reservaItem.dto.IReservaItemRequestData;

public record ReservaItemRequestData (Long idItem, Integer quantidade) implements IReservaItemRequestData {

}