package com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto;

import com.fiap.Hackaton.usecase.reserva.reservaServico.dto.IReservaServicoRequestData;

public record ReservaServicoRequestData  ( Long idServico, Integer quantidade) implements IReservaServicoRequestData{

}
