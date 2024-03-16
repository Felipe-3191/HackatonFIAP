package com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto;


import com.fiap.Hackaton.usecase.reserva.dto.IReservaServicoRequestData;

public record ReservaServicoRequestData(Long idServico, Integer quantidade) implements IReservaServicoRequestData {

}
