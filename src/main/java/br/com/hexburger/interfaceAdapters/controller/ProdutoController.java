package br.com.hexburger.interfaceAdapters.controller;

import br.com.hexburger.application.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import br.com.hexburger.application.useCase.produto.CriarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.EditarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.RemoverProdutoUseCase;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;

import java.util.List;

public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;

    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase, BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase,
                             EditarProdutoUseCase editarProdutoUseCase, RemoverProdutoUseCase removerProdutoUseCase) {
        this.criarProdutoUseCase = criarProdutoUseCase;
        this.buscarProdutosPorCategoriaUseCase = buscarProdutosPorCategoriaUseCase;
        this.editarProdutoUseCase = editarProdutoUseCase;
        this.removerProdutoUseCase = removerProdutoUseCase;
    }

    public Produto criarProduto(Produto produto) {
        return criarProdutoUseCase.criarProduto(produto);
    }

    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return buscarProdutosPorCategoriaUseCase.buscarProdutosPorCategoria(categoria);
    }

    public Produto editarProduto(Produto produto) {
        return editarProdutoUseCase.editarProduto(produto);
    }

    public void removerProduto(String id) {
        removerProdutoUseCase.removerProduto(id);
    }
}
