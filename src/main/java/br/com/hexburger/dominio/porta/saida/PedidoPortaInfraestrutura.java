package br.com.hexburger.dominio.porta.saida;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public interface PedidoPortaInfraestrutura {

    Pedido criarPedido(Pedido pedido);
    List<Pedido> buscarPedidos();

}
