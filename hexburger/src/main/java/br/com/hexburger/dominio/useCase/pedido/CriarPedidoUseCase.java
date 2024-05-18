package br.com.hexburger.dominio.useCase.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.pedido.CriarPedidoPortaInfraestrutura;

public class CriarPedidoUseCase {

    private final CriarPedidoPortaInfraestrutura criarPedidoPortaInfraestrutura;

    public CriarPedidoUseCase(CriarPedidoPortaInfraestrutura criarPedidoPortaInfraestrutura) {
        this.criarPedidoPortaInfraestrutura = criarPedidoPortaInfraestrutura;
    }

    public Pedido criarPedido(Pedido pedido) {
        return criarPedidoPortaInfraestrutura.criarPedido(pedido);
    }
}
