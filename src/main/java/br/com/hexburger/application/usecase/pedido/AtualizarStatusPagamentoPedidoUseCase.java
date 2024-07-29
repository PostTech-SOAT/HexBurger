package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;

import static br.com.hexburger.dominio.entidade.StatusPagamento.APROVADO;
import static br.com.hexburger.dominio.entidade.StatusPagamento.RECUSADO;
import static br.com.hexburger.dominio.entidade.StatusPedido.CANCELADO;
import static br.com.hexburger.dominio.entidade.StatusPedido.EM_PREPARACAO;

public class AtualizarStatusPagamentoPedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public AtualizarStatusPagamentoPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public void atualizarStatusPagamento(String idPedido, String idExternoPagamento, boolean pagamentoAprovado) {
        pedidoGateway.atualizarStatusPagamento(idPedido, idExternoPagamento, pagamentoAprovado ? APROVADO : RECUSADO);
        new AtualizarStatusPedidoUseCase(pedidoGateway).atualizarStatusPedido(idPedido, pagamentoAprovado ? EM_PREPARACAO : CANCELADO);
    }
}
