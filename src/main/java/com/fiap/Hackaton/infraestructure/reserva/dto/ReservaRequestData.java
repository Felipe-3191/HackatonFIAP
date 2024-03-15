package com.fiap.Hackaton.infraestructure.reserva.dto;

import com.fiap.Hackaton.infraestructure.reserva.reservaItem.dto.ReservaItemRequestData;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;
import com.fiap.Hackaton.usecase.reserva.dto.IReservaReservarRequestData;

import java.time.LocalDate;
import java.util.List;

public record ReservaRequestData(Long idCliente, List<Long> idQuartos, LocalDate dataInicio, LocalDate dataFim,
                                 List<ReservaServicoRequestData> servicos, List<ReservaItemRequestData> itens,
                                 Integer quantidadePessoas) implements IReservaReservarRequestData {
}
