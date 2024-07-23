package br.com.hexburger.interfaceAdapters.repositorioAdaptador;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EPedidoInterface;

import java.util.List;

public interface PedidoRepositorioAdaptador {

    EPedidoInterface criarPedido(Pedido pedido);

    List<EPedidoInterface> buscarPedidos();

}
