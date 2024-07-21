package br.com.hexburger.application.useCase.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.application.gateway.ProdutoGateway;

import java.util.List;

public class BuscarProdutosPorCategoriaUseCase {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutosPorCategoriaUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return produtoGateway.buscarProdutosPorCategoria(categoria);
    }

}
