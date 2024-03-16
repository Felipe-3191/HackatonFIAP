package com.fiap.Hackaton.usecase.reserva.dto;

import com.fiap.Hackaton.infraestructure.hotel.item.dto.ItemNomeData;
import com.fiap.Hackaton.infraestructure.hotel.servico.dto.ServicoNomeData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IReservaReservarData {
    Long id();
    LocalDate dataInicial();
    LocalDate dataFinal();
    BigDecimal valorReserva();
    BigDecimal valorTotal();
    Integer quantidadePessoas();
    String responsavelReserva();
    List<String> tipoQuarto();
    List<ServicoNomeData> servicosConsumidos();
    List<ItemNomeData> itensConsumidos();


}
