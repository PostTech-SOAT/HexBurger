package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.EditarProdutoPortaInfraestrutura;

public class EditarProdutoUseCase {

    private final EditarProdutoPortaInfraestrutura editarProdutoPortaInfraestrutura;

    public EditarProdutoUseCase(EditarProdutoPortaInfraestrutura editarProdutoPortaInfraestrutura) {
        this.editarProdutoPortaInfraestrutura = editarProdutoPortaInfraestrutura;
    }

    public Produto editarProduto(Produto produto) {
        return editarProdutoPortaInfraestrutura.editarProduto(produto);
    }

}
