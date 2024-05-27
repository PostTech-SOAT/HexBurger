package br.com.hexburger.dominio.useCase.pedido;

import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import br.com.hexburger.dominio.porta.saida.PedidoPortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;

import static br.com.hexburger.dominio.entidade.ProdutoPedido.ofProduto;

public class CriarPedidoUseCase {

    private final PedidoPortaInfraestrutura pedidoPortaInfraestrutura;
    private final ProdutoPortaInfraestrutura produtoPortaInfraestrutura;

    public CriarPedidoUseCase(PedidoPortaInfraestrutura pedidoPortaInfraestrutura, ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        this.pedidoPortaInfraestrutura = pedidoPortaInfraestrutura;
        this.produtoPortaInfraestrutura = produtoPortaInfraestrutura;
    }

    public Pedido criarPedido(Pedido pedido) {
        pedido.setCombos(pedido.getCombos().stream().map(combo -> new Combo(combo.getProdutos().stream().map(this::buscaProduto).toList())).toList());
        pedido.validaPedido();
        return pedidoPortaInfraestrutura.criarPedido(pedido);
    }

    private ProdutoPedido buscaProduto(ProdutoPedido produtoPedido) {
        return ofProduto(produtoPortaInfraestrutura.buscarProdutoPorId(produtoPedido.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não existente")));
    }
}
