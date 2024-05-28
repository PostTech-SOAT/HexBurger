package br.com.hexburger.dominio.porta.saida;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoPortaInfraestrutura {

    Produto criarProduto(Produto produto);
    Optional<Produto> buscarProdutoPorNome(String nome);
    Optional<Produto> buscarProdutoPorId(String id);
    List<Produto> buscarProdutosPorCategoria(Categoria categoria);
    Produto editarProduto(Produto produto);
    void removerProduto(String id);

}
