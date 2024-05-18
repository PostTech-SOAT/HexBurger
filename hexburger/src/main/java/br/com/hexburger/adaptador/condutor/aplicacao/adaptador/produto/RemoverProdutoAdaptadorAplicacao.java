package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.produto;

import br.com.hexburger.dominio.porta.entrada.produto.RemoverProdutoPortaAplicacao;
import br.com.hexburger.dominio.useCase.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoverProdutoAdaptadorAplicacao implements RemoverProdutoPortaAplicacao {

    private final RemoverProdutoUseCase useCase;

    @Override
    public void removerProduto(String id) {
        useCase.removerProduto(id);
    }

}
