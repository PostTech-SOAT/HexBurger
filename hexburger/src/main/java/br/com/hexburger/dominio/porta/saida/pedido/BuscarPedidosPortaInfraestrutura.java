package br.com.hexburger.dominio.porta.saida.pedido;

import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public interface BuscarPedidosPortaInfraestrutura {

    List<Pedido> buscarPedidos();
    
}
