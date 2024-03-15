package com.fiap.Hackaton.infraestructure.reserva.dto;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
import com.fiap.Hackaton.usecase.reserva.dto.IReservaPublicData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ReservaPublicData(
        Long id,
        LocalDate dataInicial,
        LocalDate dataFinal,
        BigDecimal valorReserva,
        BigDecimal valorTotal,
        Integer quantidadePessoas,
        Cliente responsavelReserva,
        List<Quarto> quartosReservados,
        List<ReservaItem> itensConsumidos,
        List<ReservaServico> servicosConsumidos

) implements IReservaPublicData {
    public ReservaPublicData(Reserva reserva) {
        this(
                reserva.getId(),
                reserva.getDataInicial(),
                reserva.getDataFinal(),
                reserva.getValorReserva(),
                reserva.getValorTotal(),
                reserva.getQuantidadePessoas(),
                reserva.getResponsavelReserva(),
                reserva.getQuartosReservados(),
                reserva.getItensConsumidos(),
                reserva.getServicosConsumidos()
        );
    }
}
