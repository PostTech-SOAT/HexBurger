package br.com.hexburger.dominio.porta.entrada.pedido;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public interface BuscarPedidosPortaAplicacao {

    List<Pedido> buscarPedidos();

}
