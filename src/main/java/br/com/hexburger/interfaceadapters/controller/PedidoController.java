package br.com.hexburger.interfaceadapters.controller;

import br.com.hexburger.application.interfacegateway.ServicoPagamentoGateway;
import br.com.hexburger.application.usecase.pedido.AtualizarStatusPagamentoPedidoUseCase;
import br.com.hexburger.application.usecase.pedido.BuscarPedidosUseCase;
import br.com.hexburger.application.usecase.pedido.BuscarStatusPagamentoPedidoUseCase;
import br.com.hexburger.application.usecase.pedido.CriarPedidoUseCase;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import br.com.hexburger.interfaceadapters.dto.PagamentoDTO;
import br.com.hexburger.interfaceadapters.dto.PedidoDTO;
import br.com.hexburger.interfaceadapters.gateway.PedidoGatewayJPA;
import br.com.hexburger.interfaceadapters.gateway.ProdutoGatewayJPA;
import br.com.hexburger.interfaceadapters.presenter.PedidoPresenter;
import br.com.hexburger.interfaceadapters.repositorioadaptador.PedidoRepositorioAdaptador;
import br.com.hexburger.interfaceadapters.repositorioadaptador.ProdutoRepositorioAdaptador;

import java.util.List;

public class PedidoController {

    public PedidoDTO criarPedido(PedidoDTO pedidoDTO, PedidoRepositorioAdaptador pedidoRepositorio, ProdutoRepositorioAdaptador produtoRepositorio, ServicoPagamentoGateway pagamentoGateway) {
        CriarPedidoUseCase useCase = new CriarPedidoUseCase(new PedidoGatewayJPA(pedidoRepositorio), new ProdutoGatewayJPA(produtoRepositorio), pagamentoGateway);
        return PedidoPresenter.toDTO(useCase.criarPedido(dtoToDomain(pedidoDTO)));
    }

    public List<PedidoDTO> buscarPedidos(PedidoRepositorioAdaptador repositorio) {
        BuscarPedidosUseCase useCase = new BuscarPedidosUseCase(new PedidoGatewayJPA(repositorio));
        return useCase.buscarPedidos().stream().map(PedidoPresenter::toDTO).toList();
    }

    public String buscarStatusPedido(String id, PedidoRepositorioAdaptador repositorio) {
        BuscarStatusPagamentoPedidoUseCase useCase = new BuscarStatusPagamentoPedidoUseCase(new PedidoGatewayJPA(repositorio));
        return useCase.buscarStatusPagamentoPedido(id);
    }

    public void atualizarStatusDoPagamento(PagamentoDTO pagamentoDTO, PedidoRepositorioAdaptador repositorio) {
        AtualizarStatusPagamentoPedidoUseCase useCase = new AtualizarStatusPagamentoPedidoUseCase(new PedidoGatewayJPA(repositorio));
        useCase.atualizarStatusPagamento(pagamentoDTO.getIdPedido(), pagamentoDTO.getIdExternoPagamento(), pagamentoDTO.isAprovado());
    }

    private Pedido dtoToDomain(PedidoDTO pedidoDTO) {
        Cliente cliente = new Cliente(pedidoDTO.getCliente().getCpf(), pedidoDTO.getCliente().getNome(), pedidoDTO.getCliente().getEmail());
        List<Combo> combos = pedidoDTO.getCombos().stream().map(combo -> new Combo(combo.getProdutos().stream().map(p -> new ProdutoPedido(p.getId())).toList())).toList();
        return new Pedido(combos, cliente);
    }

}
