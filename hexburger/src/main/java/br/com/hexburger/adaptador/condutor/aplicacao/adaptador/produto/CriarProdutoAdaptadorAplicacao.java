package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.entrada.produto.CriarProdutoPortaAplicacao;
import br.com.hexburger.dominio.useCase.produto.CriarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarProdutoAdaptadorAplicacao implements CriarProdutoPortaAplicacao {

    private final CriarProdutoUseCase useCase;

    @Override
    public Produto criarProduto(Produto produto) {
        return useCase.criarProduto(produto);
    }

}
