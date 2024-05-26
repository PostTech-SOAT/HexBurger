package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;

public class EditarProdutoUseCase {

    private final ProdutoPortaInfraestrutura produtoPortaInfraestrutura;

    public EditarProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        this.produtoPortaInfraestrutura = produtoPortaInfraestrutura;
    }

    public Produto editarProduto(Produto produto) {
        produtoPortaInfraestrutura.buscarProdutoPorId(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return produtoPortaInfraestrutura.editarProduto(produto);
    }

}
