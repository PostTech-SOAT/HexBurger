package br.com.hexburger.interfaceAdapters.controller;

import br.com.hexburger.application.useCase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.application.useCase.pedido.CriarPedidoUseCase;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import br.com.hexburger.interfaceAdapters.dto.PedidoDTO;
import br.com.hexburger.interfaceAdapters.gateway.PedidoGatewayJPA;
import br.com.hexburger.interfaceAdapters.gateway.ProdutoGatewayJPA;
import br.com.hexburger.interfaceAdapters.presenter.PedidoPresenter;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.PedidoRepositorioAdaptador;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ProdutoRepositorioAdaptador;

import java.util.List;

public class PedidoController {

    public PedidoDTO criarPedido(PedidoDTO pedidoDTO, PedidoRepositorioAdaptador pedidoRepositorio, ProdutoRepositorioAdaptador produtoRepositorio) {
        CriarPedidoUseCase useCase = new CriarPedidoUseCase(new PedidoGatewayJPA(pedidoRepositorio), new ProdutoGatewayJPA(produtoRepositorio));
        return PedidoPresenter.toDTO(useCase.criarPedido(dtoToDomain(pedidoDTO)));
    }

    public List<PedidoDTO> buscarPedidos(PedidoRepositorioAdaptador repositorio) {
        BuscarPedidosUseCase useCase = new BuscarPedidosUseCase(new PedidoGatewayJPA(repositorio));
        return useCase.buscarPedidos().stream().map(PedidoPresenter::toDTO).toList();
    }

    private Pedido dtoToDomain(PedidoDTO pedidoDTO) {
        Cliente cliente = new Cliente(pedidoDTO.getCliente().getCpf(), pedidoDTO.getCliente().getNome(), pedidoDTO.getCliente().getEmail());
        List<Combo> combos = pedidoDTO.getCombos().stream().map(combo -> new Combo(combo.getProdutos().stream().map(p -> new ProdutoPedido(p.getId())).toList())).toList();
        return new Pedido(combos, cliente);
    }

}
