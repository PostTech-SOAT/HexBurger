package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.StatusPedido;

public class AtualizarStatusPedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public AtualizarStatusPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public void atualizarStatusPedido(String idPedido, StatusPedido statusPedido) {
        pedidoGateway.atualizarStatusPedido(idPedido, statusPedido);
    }

}
