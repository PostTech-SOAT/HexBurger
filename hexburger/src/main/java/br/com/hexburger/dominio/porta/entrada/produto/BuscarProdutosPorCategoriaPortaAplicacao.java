package br.com.hexburger.dominio.porta.entrada.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;

import java.util.List;

public interface BuscarProdutosPorCategoriaPortaAplicacao {
    List<Produto> buscarProdutosPorCategoria(Categoria categoria);
}
