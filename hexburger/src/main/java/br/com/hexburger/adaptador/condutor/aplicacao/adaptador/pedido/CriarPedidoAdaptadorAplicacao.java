package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.entrada.pedido.CriarPedidoPortaAplicacao;
import br.com.hexburger.dominio.useCase.pedido.CriarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarPedidoAdaptadorAplicacao implements CriarPedidoPortaAplicacao {

    private final CriarPedidoUseCase useCase;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return useCase.criarPedido(pedido);
    }

}
