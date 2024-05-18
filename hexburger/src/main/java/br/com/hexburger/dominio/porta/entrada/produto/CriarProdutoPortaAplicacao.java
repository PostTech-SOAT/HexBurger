package br.com.hexburger.dominio.porta.entrada.produto;

import br.com.hexburger.dominio.entidade.Produto;

public interface CriarProdutoPortaAplicacao {
    Produto criarProduto(Produto produto);
}
