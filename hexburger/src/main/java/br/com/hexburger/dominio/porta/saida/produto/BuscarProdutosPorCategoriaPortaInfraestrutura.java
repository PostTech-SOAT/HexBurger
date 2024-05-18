package br.com.hexburger.dominio.porta.saida.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;

import java.util.List;

public interface BuscarProdutosPorCategoriaPortaInfraestrutura {
    List<Produto> buscarProdutosPorCategoria(Categoria categoria);
}
