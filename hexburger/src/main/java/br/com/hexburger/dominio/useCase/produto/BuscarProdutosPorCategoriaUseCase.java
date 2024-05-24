package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;

import java.util.List;

public class BuscarProdutosPorCategoriaUseCase {

    private final ProdutoPortaInfraestrutura produtoPortaInfraestrutura;

    public BuscarProdutosPorCategoriaUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        this.produtoPortaInfraestrutura = produtoPortaInfraestrutura;
    }

    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return produtoPortaInfraestrutura.buscarProdutosPorCategoria(categoria);
    }

}
