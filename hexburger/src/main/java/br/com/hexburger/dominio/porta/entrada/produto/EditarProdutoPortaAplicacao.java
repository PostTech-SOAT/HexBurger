package br.com.hexburger.dominio.porta.entrada.produto;

import br.com.hexburger.dominio.entidade.Produto;

public interface EditarProdutoPortaAplicacao {
    Produto editarProduto(Produto produto);
}
