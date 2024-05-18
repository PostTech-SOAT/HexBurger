package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.produto;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.entrada.produto.EditarProdutoPortaAplicacao;
import br.com.hexburger.dominio.useCase.produto.EditarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditarProdutoAdaptadorAplicacao implements EditarProdutoPortaAplicacao {

    private final EditarProdutoUseCase useCase;

    @Override
    public Produto editarProduto(Produto produto) {
        return useCase.editarProduto(produto);
    }

}
