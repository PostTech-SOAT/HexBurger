package br.com.hexburger.interfaceAdapters.controller;

import br.com.hexburger.application.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.application.useCase.pedido.CriarPedidoUseCase;
import br.com.hexburger.dominio.entidade.Pedido;

import java.util.List;

public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final BuscarPedidosUseCase buscarPedidosUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase, BuscarPedidosUseCase buscarPedidosUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.buscarPedidosUseCase = buscarPedidosUseCase;
    }

    public Pedido criarPedido(Pedido pedido) {
        return criarPedidoUseCase.criarPedido(pedido);
    }

    public List<Pedido> buscarPedidos() {
        return buscarPedidosUseCase.buscarPedidos();
    }

}
