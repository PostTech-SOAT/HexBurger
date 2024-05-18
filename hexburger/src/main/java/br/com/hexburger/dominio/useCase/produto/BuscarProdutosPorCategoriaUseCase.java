package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.BuscarProdutosPorCategoriaPortaInfraestrutura;

import java.util.List;

public class BuscarProdutosPorCategoriaUseCase {

    private final BuscarProdutosPorCategoriaPortaInfraestrutura buscarProdutosPorCategoriaPortaInfraestrutura;

    public BuscarProdutosPorCategoriaUseCase(BuscarProdutosPorCategoriaPortaInfraestrutura buscarProdutosPorCategoriaPortaInfraestrutura) {
        this.buscarProdutosPorCategoriaPortaInfraestrutura = buscarProdutosPorCategoriaPortaInfraestrutura;
    }

    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return buscarProdutosPorCategoriaPortaInfraestrutura.buscarProdutosPorCategoria(categoria);
    }

}
