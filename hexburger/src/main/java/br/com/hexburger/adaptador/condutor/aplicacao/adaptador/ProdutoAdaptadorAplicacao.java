package br.com.hexburger.adaptador.condutor.aplicacao.adaptador;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.entrada.ProdutoPortaAplicacao;
import br.com.hexburger.dominio.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import br.com.hexburger.dominio.useCase.produto.CriarProdutoUseCase;
import br.com.hexburger.dominio.useCase.produto.EditarProdutoUseCase;
import br.com.hexburger.dominio.useCase.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoAdaptadorAplicacao implements ProdutoPortaAplicacao {

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;

    @Override
    public Produto criarProduto(Produto produto) {
        return criarProdutoUseCase.criarProduto(produto);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return buscarProdutosPorCategoriaUseCase.buscarProdutosPorCategoria(categoria);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        return editarProdutoUseCase.editarProduto(produto);
    }

    @Override
    public void removerProduto(String id) {
        removerProdutoUseCase.removerProduto(id);
    }
}
