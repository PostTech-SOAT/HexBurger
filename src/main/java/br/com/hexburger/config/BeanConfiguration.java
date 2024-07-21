package br.com.hexburger.config;

import br.com.hexburger.application.gateway.ClienteGateway;
import br.com.hexburger.application.gateway.PedidoGateway;
import br.com.hexburger.application.gateway.ProdutoGateway;
import br.com.hexburger.application.useCase.cliente.BuscarClienteUseCase;
import br.com.hexburger.application.useCase.cliente.CriarClienteUseCase;
import br.com.hexburger.application.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.application.useCase.pedido.CriarPedidoUseCase;
import br.com.hexburger.application.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import br.com.hexburger.application.useCase.produto.CriarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.EditarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.RemoverProdutoUseCase;
import br.com.hexburger.framework.repository.PedidoRepository;
import br.com.hexburger.framework.repository.ProdutoRepository;
import br.com.hexburger.interfaceAdapters.controller.ClienteController;
import br.com.hexburger.interfaceAdapters.controller.PedidoController;
import br.com.hexburger.interfaceAdapters.controller.ProdutoController;
import br.com.hexburger.interfaceAdapters.gateway.ClienteGatewayJPA;
import br.com.hexburger.interfaceAdapters.gateway.PedidoGatewayJPA;
import br.com.hexburger.interfaceAdapters.gateway.ProdutoGatewayJPA;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ClienteRepositorioAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration { //Qualquer camada pode ser injetada?

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteGateway clienteGateway) {
        return new CriarClienteUseCase(clienteGateway);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteGateway clienteGateway) {
        return new BuscarClienteUseCase(clienteGateway);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new CriarProdutoUseCase(produtoGateway);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new EditarProdutoUseCase(produtoGateway);
    }

    @Bean
    public RemoverProdutoUseCase removerProdutoUseCase(ProdutoGateway produtoGateway) {
        return new RemoverProdutoUseCase(produtoGateway);
    }

    @Bean
    public BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase(ProdutoGateway produtoGateway) {
        return new BuscarProdutosPorCategoriaUseCase(produtoGateway);
    }

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(PedidoGateway pedidoGateway, ProdutoGateway produtoGateway) {
        return new CriarPedidoUseCase(pedidoGateway, produtoGateway);
    }

    @Bean
    public BuscarPedidosUseCase buscarPedidosUseCase(PedidoGateway pedidoGateway) {
        return new BuscarPedidosUseCase(pedidoGateway);
    }

    @Bean
    public ClienteController clienteController(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase) {
        return new ClienteController(criarClienteUseCase, buscarClienteUseCase);
    }

    @Bean
    public PedidoController pedidoController(CriarPedidoUseCase criarPedidoUseCase, BuscarPedidosUseCase buscarPedidosUseCase) {
        return new PedidoController(criarPedidoUseCase, buscarPedidosUseCase);
    }

    @Bean
    public ProdutoController produtoController(CriarProdutoUseCase criarProdutoUseCase, BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase,
                                               EditarProdutoUseCase editarProdutoUseCase, RemoverProdutoUseCase removerProdutoUseCase) {
        return new ProdutoController(criarProdutoUseCase, buscarProdutosPorCategoriaUseCase, editarProdutoUseCase, removerProdutoUseCase);
    }

    @Bean
    public ClienteGatewayJPA clienteGateway(ClienteRepositorioAdaptador repository) {
        return new ClienteGatewayJPA(repository);
    }

    @Bean
    public PedidoGatewayJPA pedidoGateway(PedidoRepository repository) {
        return new PedidoGatewayJPA(repository);
    }

    @Bean
    public ProdutoGateway produtoGateway(ProdutoRepository repository) {
        return new ProdutoGatewayJPA(repository);
    }
}
