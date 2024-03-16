package com.fiap.Hackaton.usecase.reserva;

import com.fiap.Hackaton.domain.cliente.entity.Cliente;
import com.fiap.Hackaton.domain.hotel.item.entity.Item;
import com.fiap.Hackaton.domain.hotel.servico.entity.Servico;
import com.fiap.Hackaton.domain.quarto.entity.Quarto;
import com.fiap.Hackaton.domain.reserva.entity.Reserva;
import com.fiap.Hackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.Hackaton.domain.reserva.reservaItem.entity.ReservaItem;
import com.fiap.Hackaton.domain.reserva.reservaServico.entity.ReservaServico;
import com.fiap.Hackaton.infraestructure.cliente.entityschema.ClienteEntity;
import com.fiap.Hackaton.infraestructure.reserva.reservaItem.dto.ReservaItemRequestData;
import com.fiap.Hackaton.infraestructure.reserva.reservaServico.dto.ReservaServicoRequestData;
import com.fiap.Hackaton.usecase.cliente.BuscarClienteUseCase;
import com.fiap.Hackaton.usecase.item.BuscarItemUseCase;
import com.fiap.Hackaton.usecase.quarto.usecases.BuscarQuartoPorIdUseCase;
import com.fiap.Hackaton.usecase.reserva.dto.IReservaReservarRequestData;
import com.fiap.Hackaton.usecase.servico.BuscarServicoUseCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReservarReservaUseCase {
    private final ReservaGateway reservaGateway;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase;
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final BuscarItemUseCase buscarItemUseCase;


    public ReservarReservaUseCase(ReservaGateway reservaGateway, BuscarClienteUseCase buscarClienteUseCase,
                                  BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase, BuscarServicoUseCase buscarServicoUseCase,
                                  BuscarItemUseCase buscarItemUseCase) {
        this.reservaGateway = reservaGateway;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.buscarQuartoPorIdUseCase = buscarQuartoPorIdUseCase;
        this.buscarServicoUseCase  = buscarServicoUseCase;
        this.buscarItemUseCase = buscarItemUseCase;
    }

    public Reserva executar(IReservaReservarRequestData dados) {
        Cliente cliente = this.buscarClienteUseCase.execute(dados.idCliente());
        List<Quarto> quartos = new ArrayList<>();
        List<ReservaServico> servicos = new ArrayList<>();
        List<ReservaItem> items = new ArrayList<>();
        BigDecimal valorDiariaQuartos = new BigDecimal(0);
        BigDecimal valorServicos = new BigDecimal(0);
        BigDecimal valorItems = new BigDecimal(0);

        int quantidadeDias = dados.dataFim().getDayOfYear() - dados.dataInicio().getDayOfYear();

        for(Long idQuarto : dados.idQuartos()){
            Quarto quarto = this.buscarQuartoPorIdUseCase.execute(idQuarto);
            quartos.add(quarto);
            valorDiariaQuartos = valorDiariaQuartos.add(quarto.getValorDiaria());
        }
        for(ReservaServicoRequestData reservaServico : dados.servicos()){
            ReservaServico reservaServicoAlterado = new ReservaServico();
            reservaServicoAlterado.setQuantidade(reservaServico.quantidade());
            Servico servico = this.buscarServicoUseCase.execute(reservaServico.idServico());
            reservaServicoAlterado.setServico(servico);
            servicos.add(reservaServicoAlterado);
            valorServicos = valorServicos.add(servico.getValor().multiply(new BigDecimal(reservaServico.quantidade())));
        }

        for (ReservaItemRequestData reservaItem : dados.itens()){
            ReservaItem reservaItemAlterado = new ReservaItem();
            reservaItemAlterado.setQuantidade(reservaItem.quantidade());
            Item item = this.buscarItemUseCase.execute(reservaItem.idItem());
            reservaItemAlterado.setItem(item);
            items.add(reservaItemAlterado);
            valorItems = valorItems.add(item.getValor().multiply(new BigDecimal(reservaItem.quantidade())));
        }


        BigDecimal valorReserva = valorDiariaQuartos.multiply(new BigDecimal(quantidadeDias));
        BigDecimal valorTotal = valorReserva.add(valorServicos).add(valorItems).add(valorReserva);

        Reserva reserva = new Reserva(cliente, quartos, dados.dataInicio(), dados.dataFim(), valorReserva,
                valorTotal,servicos, items,
                dados.quantidadePessoas());

        return this.reservaGateway.reservar(reserva);
    }
}
