package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EPedido;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.PedidoRepository;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.PedidoPortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EPedido.toEntity;

@Component
@RequiredArgsConstructor
public class PedidoAdaptadoInfraestrutura implements PedidoPortaInfraestrutura {

    private final PedidoRepository repository;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return repository.save(toEntity(pedido)).toDomain();
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return repository.findAll().stream().map(EPedido::toDomain).toList();
    }

}
