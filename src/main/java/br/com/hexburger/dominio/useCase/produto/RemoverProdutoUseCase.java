package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;

public class RemoverProdutoUseCase {

    private final ProdutoPortaInfraestrutura produtoPortaInfraestrutura;

    public RemoverProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        this.produtoPortaInfraestrutura = produtoPortaInfraestrutura;
    }

    public void removerProduto(String id) {
        produtoPortaInfraestrutura.buscarProdutoPorId(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        produtoPortaInfraestrutura.removerProduto(id);
    }

}
