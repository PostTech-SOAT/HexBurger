package br.com.hexburger.dominio.porta.saida.produto;

import br.com.hexburger.dominio.entidade.Produto;

public interface CriarProdutoPortaInfraestrutura {
    Produto criarProduto(Produto produto);
}