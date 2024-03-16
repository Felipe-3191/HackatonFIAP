package com.fiap.Hackaton.infraestructure.reserva.dto;

import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
import com.fiap.Hackaton.infraestructure.hotel.item.dto.ItemNomeData;
import com.fiap.Hackaton.infraestructure.hotel.servico.dto.ServicoNomeData;
import com.fiap.Hackaton.usecase.reserva.dto.IReservaReservarData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ReservaReservarData(
        Long id,
        LocalDate dataInicial,
        LocalDate dataFinal,
        BigDecimal valorReserva,
        BigDecimal valorTotal,
        Integer quantidadePessoas,
        String responsavelReserva,
        List<String> tipoQuarto,
        List<ServicoNomeData> servicosConsumidos,
        List<ItemNomeData> itensConsumidos) implements IReservaReservarData {
    public ReservaReservarData(Reserva reserva) {
        this(
                reserva.getId(),
                reserva.getDataInicial(),
                reserva.getDataFinal(),
                reserva.getValorReserva(),
                reserva.getValorTotal(),
                reserva.getQuantidadePessoas(),
                reserva.getResponsavelReserva().getNome(),
                reserva.getQuartosReservados().stream().map(Quarto::getTipoQuarto).map(TipoQuarto::getNomeTipo).toList(),
                reserva.getServicosConsumidos().stream().map(ReservaServico::getServico)
                        .map(Servico::getNome).map(ServicoNomeData::new).toList(),
                reserva.getItensConsumidos().stream().map(ReservaItem::getItem).map(Item::getNome)
                        .map(ItemNomeData::new).toList()
        );
    }
}
