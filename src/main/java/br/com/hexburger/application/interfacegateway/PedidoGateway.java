package br.com.hexburger.application.interfacegateway;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPagamento;
import br.com.hexburger.dominio.entidade.StatusPedido;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {

    Pedido criarPedido(Pedido pedido);
    List<Pedido> buscarPedidos();
    Optional<String> buscarStatusPagamentoPedido(String id);
    void atualizarStatusPagamento(String idPedido, String idExternoPagamento, StatusPagamento statusPagamento);
    void atualizarStatusPedido(String idPedido, StatusPedido statusPedido);
}
