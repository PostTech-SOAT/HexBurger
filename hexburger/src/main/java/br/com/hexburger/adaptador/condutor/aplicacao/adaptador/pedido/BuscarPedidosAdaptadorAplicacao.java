package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.pedido;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.entrada.pedido.BuscarPedidosPortaAplicacao;
import br.com.hexburger.dominio.useCase.pedido.BuscarPedidosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPedidosAdaptadorAplicacao implements BuscarPedidosPortaAplicacao {

    private final BuscarPedidosUseCase useCase;

    @Override
    public List<Pedido> buscarPedidos() {
        return useCase.buscarPedidos();
    }

}
