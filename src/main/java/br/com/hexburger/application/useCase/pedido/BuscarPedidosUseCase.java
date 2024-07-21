package br.com.hexburger.application.useCase.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.application.gateway.PedidoGateway;

import java.util.List;

public class BuscarPedidosUseCase {

    private final PedidoGateway pedidoGateway;

    public BuscarPedidosUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public List<Pedido> buscarPedidos() {
        return pedidoGateway.buscarPedidos();
    }
}
