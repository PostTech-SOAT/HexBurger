package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.CriarProdutoPortaInfraestrutura;

public class CriarProdutoUseCase {

    private final CriarProdutoPortaInfraestrutura criarProdutoPortaInfraestrutura;

    public CriarProdutoUseCase(CriarProdutoPortaInfraestrutura criarProdutoPortaInfraestrutura) {
        this.criarProdutoPortaInfraestrutura = criarProdutoPortaInfraestrutura;
    }

    public Produto criarProduto(Produto produto) {
        return criarProdutoPortaInfraestrutura.criarProduto(produto);
    }
}
