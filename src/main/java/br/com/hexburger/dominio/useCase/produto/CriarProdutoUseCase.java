package br.com.hexburger.dominio.useCase.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ConflictException;

public class CriarProdutoUseCase {

    private final ProdutoPortaInfraestrutura produtoPortaInfraestrutura;

    public CriarProdutoUseCase(ProdutoPortaInfraestrutura produtoPortaInfraestrutura) {
        this.produtoPortaInfraestrutura = produtoPortaInfraestrutura;
    }

    public Produto criarProduto(Produto produto) {
        produtoPortaInfraestrutura.buscarProdutoPorNome(produto.getNome()).ifPresent(p -> {
            throw new ConflictException("Produto já cadastrado");
        });
        return produtoPortaInfraestrutura.criarProduto(produto);
    }
}
