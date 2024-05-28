package br.com.hexburger.dominio.porta.entrada;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public interface PedidoPortaAplicacao {

    Pedido criarPedido(Pedido pedido);
    List<Pedido> buscarPedidos();

}
