package com.fiap.Hackaton.infraestructure;

import com.fiap.Hackaton.domain.cliente.gateway.ClienteGateway;
import com.fiap.Hackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.Hackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.Hackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.Hackaton.domain.predio.gateway.PredioGateway;
import com.fiap.Hackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.Hackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.Hackaton.infraestructure.cliente.gateway.ClienteDatabaseGateway;
import com.fiap.Hackaton.infraestructure.cliente.repository.ClienteRepository;
import com.fiap.Hackaton.infraestructure.hotel.gateway.HotelDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.gateway.ItemDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.item.repository.ItemRepository;
import com.fiap.Hackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.Hackaton.infraestructure.hotel.servico.gateway.ServicoDatabaseGateway;
import com.fiap.Hackaton.infraestructure.hotel.servico.repository.ServicoRepository;
import com.fiap.Hackaton.infraestructure.predio.gateway.PredioDatabaseGateway;
import com.fiap.Hackaton.infraestructure.predio.repository.PredioRepository;
import com.fiap.Hackaton.infraestructure.quarto.gateway.QuartoDatabaseGateway;
import com.fiap.Hackaton.infraestructure.quarto.repository.QuartoRepository;
import com.fiap.Hackaton.infraestructure.tipoquarto.gateway.TipoQuartoDatabaseGateway;
import com.fiap.Hackaton.infraestructure.tipoquarto.repository.TipoQuartoRepository;
import com.fiap.Hackaton.usecase.cliente.*;
import com.fiap.Hackaton.usecase.hotel.*;
import com.fiap.Hackaton.usecase.item.*;
import com.fiap.Hackaton.usecase.predio.*;
import com.fiap.Hackaton.usecase.quarto.usecases.*;
import com.fiap.Hackaton.usecase.servico.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {
    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new AtualizarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarClientePorCpfUseCase buscarClientePorCpfUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClientePorCpfUseCase(clienteGateway);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarTodosClientesUseCase buscarTodosClientesUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new BuscarTodosClientesUseCase(clienteGateway);
    }

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new CriarClienteUseCase(clienteGateway);
    }

    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(ClienteRepository repository) {
        ClienteGateway clienteGateway = new ClienteDatabaseGateway(repository);
        return new DeletarClienteUseCase(clienteGateway);
    }

    @Bean
    public CriarHotelUseCase criarHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new CriarHotelUseCase(hotelGateway);
    }

    @Bean
    public AtualizarHotelUseCase atualizarHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new AtualizarHotelUseCase(hotelGateway);
    }

    @Bean
    public BuscarTodosHoteisUseCase buscarTodosHoteisUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarTodosHoteisUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorIdUseCase buscarHotelPorIdUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorIdUseCase(hotelGateway);
    }


    @Bean
    public BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorCEPUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorLogradouroUseCase(hotelGateway);
    }

    @Bean
    public BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new BuscarHotelPorNomeUseCase(hotelGateway);
    }

    @Bean
    public DeletarHotelUseCase deletarHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new DeletarHotelUseCase(hotelGateway);
    }


    @Bean
    public AdicionarPredioUseCase adicionarPredioUseCase(HotelRepository repository, CriarPredioUseCase criarPredioUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new AdicionarPredioUseCase(hotelGateway, criarPredioUseCase);
    }

    @Bean
    public AdicionarServicoUseCase adicionarServicoUseCase(HotelRepository repository, BuscarServicoUseCase buscarServicoUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new AdicionarServicoUseCase(hotelGateway, buscarServicoUseCase);
    }

    @Bean
    public RemoverServicoUseCase removerServicoUseCase(HotelRepository repository, BuscarServicoUseCase buscarServicoUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new RemoverServicoUseCase(hotelGateway, buscarServicoUseCase);
    }

    @Bean
    public AdicionarItemUseCase adicionarItemUseCase(HotelRepository repository, BuscarItemUseCase buscarItemUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new AdicionarItemUseCase(hotelGateway, buscarItemUseCase);
    }


    @Bean
    public RemoverItemUseCase removerItemUseCase(HotelRepository repository, BuscarItemUseCase buscarItemUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new RemoverItemUseCase(hotelGateway, buscarItemUseCase);
    }

    @Bean
    public RemoverPredioUseCase removerPredioUseCase(HotelRepository repository, DeletarPredioUseCase deletarPredioUseCase) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);

        return new RemoverPredioUseCase(hotelGateway, deletarPredioUseCase);
    }

    @Bean
    public BuscarTodosPrediosUseCase buscarTodosPrediosUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarTodosPrediosUseCase(predioGateway);
    }

    @Bean
    public BuscarPredioUseCase buscarPredioUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarPredioUseCase(predioGateway);
    }


    @Bean
    public BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new BuscarPredioPorNomeUseCase(predioGateway);
    }


    @Bean
    public AtualizarPredioUseCase atualizarPredioUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);

        return new AtualizarPredioUseCase(predioGateway);
    }

    @Bean
    public CriarPredioUseCase criarPredioUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);
        return new CriarPredioUseCase(predioGateway);
    }

    @Bean
    public DeletarPredioUseCase deletarPredioUseCase(PredioRepository repository) {
        PredioGateway predioGateway = new PredioDatabaseGateway(repository);
        return new DeletarPredioUseCase(predioGateway);
    }

    @Bean
    public AtualizarItemUseCase atualizarItemUseCase(ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new AtualizarItemUseCase(itemGateway);
    }

    @Bean
    public BuscarItemUseCase buscarItemUseCase(ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new BuscarItemUseCase(itemGateway);
    }

    @Bean
    public BuscarTodosItensUseCase buscarTodosItensUseCase(ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new BuscarTodosItensUseCase(itemGateway);
    }

    @Bean
    public CriarItemUseCase criarItemUseCase(ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new CriarItemUseCase(itemGateway);
    }

    @Bean
    public BuscarTodosServicosUseCase buscarTodosServicosUseCase(ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new BuscarTodosServicosUseCase(servicoGateway);
    }

    @Bean
    public BuscarServicoUseCase buscarServicoUserCase(ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new BuscarServicoUseCase(servicoGateway);
    }

    @Bean
    public CriarServicoUseCase criarServicoUseCase(ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new CriarServicoUseCase(servicoGateway);
    }

    @Bean
    public AtualizarServicoUseCase atualizarServicoUseCase(ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new AtualizarServicoUseCase(servicoGateway);
    }

    @Bean
    public DeletarServicoUseCase deletarServicoUseCase(ServicoRepository repository) {
        ServicoGateway servicoGateway = new ServicoDatabaseGateway(repository);
        return new DeletarServicoUseCase(servicoGateway);
    }

    @Bean
    public DeletarItemUseCase deletarItemUseCase(ItemRepository repository) {
        ItemGateway itemGateway = new ItemDatabaseGateway(repository);
        return new DeletarItemUseCase(itemGateway);
    }

    @Bean
    public AtualizarQuartoUseCase atualizarQuartoUseCase(QuartoRepository repository, TipoQuartoRepository tipoQuartoRepository, PredioRepository predioRepository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        TipoQuartoGateway tipoQuartoGateway = new TipoQuartoDatabaseGateway(tipoQuartoRepository);
        PredioGateway predioGateway = new PredioDatabaseGateway(predioRepository);
        return new AtualizarQuartoUseCase(quartoGateway, predioGateway, tipoQuartoGateway);
    }

    @Bean
    public BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase(QuartoRepository repository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        return new BuscarQuartoPorIdUseCase(quartoGateway);
    }

    @Bean
    public BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase(QuartoRepository quartoRepository, TipoQuartoRepository tipoQuartoRepository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(quartoRepository);
        TipoQuartoGateway tipoQuartoGateway = new TipoQuartoDatabaseGateway(tipoQuartoRepository);
        return new BuscarQuartoPorQuantidadeDeHospedesUseCase(quartoGateway, tipoQuartoGateway);
    }

    @Bean
    public BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase(QuartoRepository repository, TipoQuartoRepository tipoQuartoRepository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        TipoQuartoGateway tipoQuartoGateway = new TipoQuartoDatabaseGateway(tipoQuartoRepository);
        return new BuscarQuartoPorTipoUseCase(quartoGateway, tipoQuartoGateway);
    }

    @Bean
    public BuscarTodosQuartosUseCase buscarTodosQuartosUseCase(QuartoRepository repository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        return new BuscarTodosQuartosUseCase(quartoGateway);
    }

    @Bean
    public CriarQuartoUseCase criarQuartoUseCase(QuartoRepository repository,
                                                 TipoQuartoRepository tipoQuartoRepository,
                                                 PredioRepository predioRepository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        TipoQuartoGateway tipoQuartoGateway = new TipoQuartoDatabaseGateway(tipoQuartoRepository);
        PredioGateway predioGateway = new PredioDatabaseGateway(predioRepository);
        return new CriarQuartoUseCase(quartoGateway, predioGateway, tipoQuartoGateway);
    }

    @Bean
    public DeletarQuartoUseCase deletarQuartoUseCase(QuartoRepository repository) {
        QuartoGateway quartoGateway = new QuartoDatabaseGateway(repository);
        return new DeletarQuartoUseCase(quartoGateway);
    }


    @Bean
    public ListarServicosHotelUseCase listarServicosHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new ListarServicosHotelUseCase(hotelGateway);
    }

    @Bean
    public ListarItensHotelUseCase listarItensHotelUseCase(HotelRepository repository) {
        HotelGateway hotelGateway = new HotelDatabaseGateway(repository);
        return new ListarItensHotelUseCase(hotelGateway);
    }
}
