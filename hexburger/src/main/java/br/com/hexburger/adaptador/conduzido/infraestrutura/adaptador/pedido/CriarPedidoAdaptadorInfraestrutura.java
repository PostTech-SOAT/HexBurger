package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.pedido;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.PedidoRepository;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.porta.saida.pedido.CriarPedidoPortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EPedido.toEntity;

@Component
@RequiredArgsConstructor
public class CriarPedidoAdaptadorInfraestrutura implements CriarPedidoPortaInfraestrutura {

    private final PedidoRepository repository;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return repository.save(toEntity(pedido)).toDomain();
    }

}
