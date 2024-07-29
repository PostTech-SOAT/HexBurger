package br.com.hexburger.application.usecase.produto;

import br.com.hexburger.application.interfacegateway.ProdutoGateway;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;

public class RemoverProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public RemoverProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public void removerProduto(String id) {
        produtoGateway.buscarProdutoPorId(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        produtoGateway.removerProduto(id);
    }

}
