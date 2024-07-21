package br.com.hexburger.application.useCase.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.application.gateway.ProdutoGateway;
import br.com.hexburger.dominio.util.exception.ConflictException;

public class CriarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public CriarProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto criarProduto(Produto produto) {
        produtoGateway.buscarProdutoPorNome(produto.getNome()).ifPresent(p -> {
            throw new ConflictException("Produto já cadastrado");
        });
        return produtoGateway.criarProduto(produto);
    }
}
