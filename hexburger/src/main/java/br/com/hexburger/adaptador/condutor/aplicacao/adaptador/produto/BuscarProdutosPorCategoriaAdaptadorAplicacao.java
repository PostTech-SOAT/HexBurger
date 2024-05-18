package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.produto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.entrada.produto.BuscarProdutosPorCategoriaPortaAplicacao;
import br.com.hexburger.dominio.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarProdutosPorCategoriaAdaptadorAplicacao implements BuscarProdutosPorCategoriaPortaAplicacao {

    private final BuscarProdutosPorCategoriaUseCase useCase;

    @Override
    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return useCase.buscarProdutosPorCategoria(categoria);
    }
}
