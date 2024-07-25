package br.com.hexburger.application.useCase.produto;

import br.com.hexburger.application.gateway.ProdutoGateway;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;

import java.util.UUID;

public class BuscarProdutoPorIdUseCase {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPorIdUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public ProdutoPedido buscaProduto(ProdutoPedido produtoPedido) {
        Produto produto = produtoGateway.buscarProdutoPorId(produtoPedido.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não existente"));
        return new ProdutoPedido(UUID.randomUUID().toString(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria());
    }

}
