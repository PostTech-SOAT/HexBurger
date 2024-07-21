package br.com.hexburger.interfaceAdapters.gateway;

import br.com.hexburger.application.gateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.framework.entidade.EPedido;
import br.com.hexburger.framework.repository.PedidoRepository;

import java.util.List;

import static br.com.hexburger.framework.entidade.EPedido.toEntity;

public class PedidoGatewayJPA implements PedidoGateway {

    private final PedidoRepository repository;

    public PedidoGatewayJPA(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return repository.save(toEntity(pedido)).toDomain();
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return repository.findAll().stream().map(EPedido::toDomain).toList();
    }

}
