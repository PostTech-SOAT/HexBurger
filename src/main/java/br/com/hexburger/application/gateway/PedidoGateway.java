package br.com.hexburger.application.gateway;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway {

    Pedido criarPedido(Pedido pedido);
    List<Pedido> buscarPedidos();
    Optional<String> buscarStatusPagamentoPedido(String id);

}
