package br.com.hexburger.dominio.useCase.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.PedidoPortaInfraestrutura;

import java.util.List;

public class BuscarPedidosUseCase {

    private final PedidoPortaInfraestrutura pedidoPortaInfraestrutura;

    public BuscarPedidosUseCase(PedidoPortaInfraestrutura pedidoPortaInfraestrutura) {
        this.pedidoPortaInfraestrutura = pedidoPortaInfraestrutura;
    }

    public List<Pedido> buscarPedidos() {
        return pedidoPortaInfraestrutura.buscarPedidos();
    }
}
