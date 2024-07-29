package br.com.hexburger.application.usecase.produto;

import br.com.hexburger.application.interfacegateway.ProdutoGateway;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;
import br.com.hexburger.dominio.entidade.Produto;

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
