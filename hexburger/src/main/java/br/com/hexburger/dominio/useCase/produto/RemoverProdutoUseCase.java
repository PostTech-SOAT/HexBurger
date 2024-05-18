package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.porta.saida.produto.RemoverProdutoPortaInfraestrutura;

public class RemoverProdutoUseCase {

    private final RemoverProdutoPortaInfraestrutura removerProdutoPortaInfraestrutura;

    public RemoverProdutoUseCase(RemoverProdutoPortaInfraestrutura removerProdutoPortaInfraestrutura) {
        this.removerProdutoPortaInfraestrutura = removerProdutoPortaInfraestrutura;
    }

    public void removerProduto(String id) {
        removerProdutoPortaInfraestrutura.removerProduto(id);
    }

}
