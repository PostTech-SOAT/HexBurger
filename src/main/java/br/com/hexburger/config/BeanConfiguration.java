package br.com.hexburger.config;

import br.com.hexburger.application.gateway.PedidoGateway;
import br.com.hexburger.application.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.application.useCase.pedido.CriarPedidoUseCase;
import br.com.hexburger.framework.repository.PedidoRepository;
import br.com.hexburger.interfaceAdapters.controller.PedidoController;
import br.com.hexburger.interfaceAdapters.gateway.PedidoGatewayJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(PedidoGateway pedidoGateway) {
        return new CriarPedidoUseCase(pedidoGateway);
    }

    @Bean
    public BuscarPedidosUseCase buscarPedidosUseCase(PedidoGateway pedidoGateway) {
        return new BuscarPedidosUseCase(pedidoGateway);
    }


    @Bean
    public PedidoController pedidoController(CriarPedidoUseCase criarPedidoUseCase, BuscarPedidosUseCase buscarPedidosUseCase) {
        return new PedidoController(criarPedidoUseCase, buscarPedidosUseCase);
    }

    @Bean
    public PedidoGatewayJPA pedidoGateway(PedidoRepository repository) {
        return new PedidoGatewayJPA(repository);
    }

}
