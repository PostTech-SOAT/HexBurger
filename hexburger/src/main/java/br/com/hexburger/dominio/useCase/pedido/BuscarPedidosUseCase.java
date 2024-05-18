package br.com.hexburger.dominio.useCase.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.pedido.BuscarPedidosPortaInfraestrutura;

import java.util.List;

public class BuscarPedidosUseCase {

    private final BuscarPedidosPortaInfraestrutura buscarPedidosPortaInfraestrutura;

    public BuscarPedidosUseCase(BuscarPedidosPortaInfraestrutura buscarPedidosPortaInfraestrutura) {
        this.buscarPedidosPortaInfraestrutura = buscarPedidosPortaInfraestrutura;
    }

    public List<Pedido> buscarPedidos() {
        return buscarPedidosPortaInfraestrutura.buscarPedidos();
    }
}
