package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;

public class BuscarStatusPagamentoPedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public BuscarStatusPagamentoPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public String buscarStatusPagamentoPedido(String id) {
        return pedidoGateway.buscarStatusPagamentoPedido(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }
}
