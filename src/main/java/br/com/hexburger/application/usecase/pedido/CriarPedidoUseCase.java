package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.application.interfacegateway.ProdutoGateway;
import br.com.hexburger.application.interfacegateway.ServicoPagamentoGateway;
import br.com.hexburger.application.usecase.pedido.dto.PagamentoResponse;
import br.com.hexburger.application.usecase.produto.BuscarProdutoPorIdUseCase;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;

public class CriarPedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final ProdutoGateway produtoGateway;
    private final ServicoPagamentoGateway servicoPagamentoGateway;

    public CriarPedidoUseCase(PedidoGateway pedidoGateway, ProdutoGateway produtoGateway, ServicoPagamentoGateway servicoPagamentoGateway) {
        this.pedidoGateway = pedidoGateway;
        this.produtoGateway = produtoGateway;
        this.servicoPagamentoGateway = servicoPagamentoGateway;
    }

    public Pedido criarPedido(Pedido pedido) {
        pedido.setCombos(pedido.getCombos().stream().map(combo -> new Combo(combo.getProdutos().stream()
                .map(produto -> new BuscarProdutoPorIdUseCase(produtoGateway).buscaProduto(produto)).toList()))
                .toList());
        pedido.validaPedido();
        PagamentoResponse pagamentoResponse = servicoPagamentoGateway.gerarPagamento(pedido.getId(), pedido.getValorTotal());
        pedido.setInformacoesPagamento(pagamentoResponse.getQrCode(), pagamentoResponse.getIdExterno());
        return pedidoGateway.criarPedido(pedido);
    }

}
