package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Pedido;

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
