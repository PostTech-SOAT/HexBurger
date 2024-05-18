package br.com.hexburger.dominio.porta.saida.pedido;

import br.com.hexburger.dominio.entidade.Pedido;

public interface CriarPedidoPortaInfraestrutura {

    Pedido criarPedido(Pedido pedido);

}
