package br.com.hexburger.application.gateway;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public interface PedidoGateway {

    Pedido criarPedido(Pedido pedido);
    List<Pedido> buscarPedidos();

}
