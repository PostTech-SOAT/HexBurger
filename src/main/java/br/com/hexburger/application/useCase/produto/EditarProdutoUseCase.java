package br.com.hexburger.application.useCase.produto;

import br.com.hexburger.application.gateway.ProdutoGateway;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;

public class EditarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public EditarProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto editarProduto(Produto produto) {
        produtoGateway.buscarProdutoPorId(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return produtoGateway.editarProduto(produto);
    }

}
