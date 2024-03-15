package com.fiap.Hackaton.usecase.reserva.dto;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IReservaPublicData {
    Long id();
    LocalDate dataInicial();
    LocalDate dataFinal();
    BigDecimal valorReserva();
    BigDecimal valorTotal();
    Integer quantidadePessoas();
    Cliente responsavelReserva();
    List<Quarto> quartosReservados();
    List<ReservaItem> itensConsumidos();
    List<ReservaServico> servicosConsumidos();
}
