package br.com.hexburger.dominio.porta.entrada;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;

import java.util.List;

public interface ProdutoPortaAplicacao {

    Produto criarProduto(Produto produto);
    List<Produto> buscarProdutosPorCategoria(Categoria categoria);
    Produto editarProduto(Produto produto);
    void removerProduto(String id);

}
