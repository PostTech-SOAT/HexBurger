package br.com.hexburger.dominio.useCase.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.PedidoPortaInfraestrutura;

public class CriarPedidoUseCase {

    private final PedidoPortaInfraestrutura pedidoPortaInfraestrutura;

    public CriarPedidoUseCase(PedidoPortaInfraestrutura pedidoPortaInfraestrutura) {
        this.pedidoPortaInfraestrutura = pedidoPortaInfraestrutura;
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoPortaInfraestrutura.criarPedido(pedido);
    }
}
