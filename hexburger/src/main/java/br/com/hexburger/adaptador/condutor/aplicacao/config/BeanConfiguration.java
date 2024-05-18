package br.com.hexburger.adaptador.condutor.aplicacao.config;

import br.com.hexburger.dominio.porta.saida.cliente.BuscarClientePortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.cliente.CriarClientePortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.pedido.BuscarPedidosPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.pedido.CriarPedidoPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.produto.BuscarProdutosPorCategoriaPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.produto.CriarProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.produto.EditarProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.produto.RemoverProdutoPortaInfraestrutura;
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
    public CriarClienteUseCase criarClienteUseCase(CriarClientePortaInfraestrutura criarClientePortaInfraestrutura) {
        return new CriarClienteUseCase(criarClientePortaInfraestrutura);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClientePortaInfraestrutura buscarClientePortaInfraestrutura) {
        return new BuscarClienteUseCase(buscarClientePortaInfraestrutura);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(CriarProdutoPortaInfraestrutura criarProdutoPortaInfraestrutura) {
        return new CriarProdutoUseCase(criarProdutoPortaInfraestrutura);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(EditarProdutoPortaInfraestrutura editarProdutoPortaInfraestrutura) {
        return new EditarProdutoUseCase(editarProdutoPortaInfraestrutura);
    }

    @Bean
    public RemoverProdutoUseCase removerProdutoUseCase(RemoverProdutoPortaInfraestrutura removerProdutoPortaInfraestrutura) {
        return new RemoverProdutoUseCase(removerProdutoPortaInfraestrutura);
    }

    @Bean
    public BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase(BuscarProdutosPorCategoriaPortaInfraestrutura buscarProdutosPorCategoriaPortaInfraestrutura) {
        return new BuscarProdutosPorCategoriaUseCase(buscarProdutosPorCategoriaPortaInfraestrutura);
    }

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(CriarPedidoPortaInfraestrutura criarPedidoPortaInfraestrutura) {
        return new CriarPedidoUseCase(criarPedidoPortaInfraestrutura);
    }

    @Bean
    public BuscarPedidosUseCase buscarPedidosUseCase(BuscarPedidosPortaInfraestrutura buscarPedidosPortaInfraestrutura) {
        return new BuscarPedidosUseCase(buscarPedidosPortaInfraestrutura);
    }
}
