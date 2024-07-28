package br.com.hexburger.application.useCase.pedido;

import br.com.hexburger.application.gateway.PedidoGateway;
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
