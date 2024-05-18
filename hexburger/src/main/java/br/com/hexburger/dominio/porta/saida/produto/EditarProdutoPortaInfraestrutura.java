package br.com.hexburger.dominio.porta.saida.produto;

import br.com.hexburger.dominio.entidade.Produto;

public interface EditarProdutoPortaInfraestrutura {
    Produto editarProduto(Produto produto);
}
