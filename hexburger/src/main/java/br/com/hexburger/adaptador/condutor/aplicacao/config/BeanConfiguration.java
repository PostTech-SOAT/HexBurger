package br.com.hexburger.adaptador.condutor.aplicacao.config;

import br.com.hexburger.dominio.porta.saida.ClientePortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.PedidoPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.useCase.cliente.BuscarClienteUseCase;
import br.com.hexburger.dominio.useCase.cliente.CriarClienteUseCase;
import br.com.hexburger.dominio.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.dominio.useCase.pedido.CriarPedidoUseCase;
import br.com.hexburger.dominio.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import br.com.hexburger.dominio.useCase.produto.CriarProdutoUseCase;
import br.com.hexburger.dominio.useCase.produto.EditarProdutoUseCase;
import br.com.hexburger.dominio.useCase.produto.RemoverProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClientePortaInfraestrutura clientePortaInfraestrutura) {
        return new CriarClienteUseCase(clientePortaInfraestrutura);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClientePortaInfraestrutura clientePortaInfraestrutura) {
        return new BuscarClienteUseCase(clientePortaInfraestrutura);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        return new CriarProdutoUseCase(produtoPortaInfraestrutura);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        return new EditarProdutoUseCase(produtoPortaInfraestrutura);
    }

    @Bean
    public RemoverProdutoUseCase removerProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        return new RemoverProdutoUseCase(produtoPortaInfraestrutura);
    }

    @Bean
    public BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        return new BuscarProdutosPorCategoriaUseCase(produtoPortaInfraestrutura);
    }

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(PedidoPortaInfraestrutura pedidoPortaInfraestrutura) {
        return new CriarPedidoUseCase(pedidoPortaInfraestrutura);
    }

    @Bean
    public BuscarPedidosUseCase buscarPedidosUseCase(PedidoPortaInfraestrutura pedidoPortaInfraestrutura) {
        return new BuscarPedidosUseCase(pedidoPortaInfraestrutura);
    }
}
