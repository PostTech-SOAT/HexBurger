package br.com.hexburger.application.useCase.pedido;

import br.com.hexburger.application.gateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;

public class CriarPedidoUseCase {

    private final PedidoGateway pedidoGateway;
//    private final ProdutoGateway produtoGateway;

    public CriarPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
//        this.produtoGateway = produtoGateway;
    }

    public Pedido criarPedido(Pedido pedido) {
        pedido.setCombos(pedido.getCombos().stream().map(combo -> new Combo(combo.getProdutos().stream()
//                .map(this::buscaProduto)
                .toList())).toList());
        pedido.validaPedido();
        return pedidoGateway.criarPedido(pedido);
    }

//    private ProdutoPedido buscaProduto(ProdutoPedido produtoPedido) {
//        return ofProduto(produtoGateway.buscarProdutoPorId(produtoPedido.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não existente")));
//    }
}
