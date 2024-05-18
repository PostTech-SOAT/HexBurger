package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.pedido;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EPedido;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.PedidoRepository;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.pedido.BuscarPedidosPortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPedidosAdaptadorInfraestrutura implements BuscarPedidosPortaInfraestrutura {

    private final PedidoRepository repository;

    @Override
    public List<Pedido> buscarPedidos() {
        return repository.findAll().stream().map(EPedido::toDomain).toList();
    }
}
