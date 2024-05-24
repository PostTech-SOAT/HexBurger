package br.com.hexburger.adaptador.condutor.aplicacao.adaptador;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.entrada.PedidoPortaAplicacao;
import br.com.hexburger.dominio.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.dominio.useCase.pedido.CriarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoAdaptadorAplicacao implements PedidoPortaAplicacao {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final BuscarPedidosUseCase buscarPedidosUseCase;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return criarPedidoUseCase.criarPedido(pedido);
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return buscarPedidosUseCase.buscarPedidos();
    }

}
