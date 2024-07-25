package br.com.hexburger.interfaceAdapters.controller;

import br.com.hexburger.application.useCase.produto.BuscarProdutosPorCategoriaUseCase;
import br.com.hexburger.application.useCase.produto.CriarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.EditarProdutoUseCase;
import br.com.hexburger.application.useCase.produto.RemoverProdutoUseCase;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.interfaceAdapters.dto.ProdutoDTO;
import br.com.hexburger.interfaceAdapters.gateway.ProdutoGatewayJPA;
import br.com.hexburger.interfaceAdapters.presenter.ProdutoPresenter;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ProdutoRepositorioAdaptador;

import java.util.List;

import static br.com.hexburger.dominio.entidade.Categoria.valueOf;

public class ProdutoController {

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO, ProdutoRepositorioAdaptador repositorio) {
        CriarProdutoUseCase useCase = new CriarProdutoUseCase(new ProdutoGatewayJPA(repositorio));
        return ProdutoPresenter.toDTO(useCase.criarProduto(new Produto(produtoDTO.getNome(),
                produtoDTO.getDescricao(), produtoDTO.getValor(), produtoDTO.getCategoria())));
    }

    public ProdutoDTO editarProduto(String id, ProdutoDTO produtoDTO, ProdutoRepositorioAdaptador repositorio) {
        EditarProdutoUseCase useCase = new EditarProdutoUseCase(new ProdutoGatewayJPA(repositorio));
        return ProdutoPresenter.toDTO(useCase.editarProduto(new Produto(id, produtoDTO.getNome(),
                produtoDTO.getDescricao(), produtoDTO.getValor(), produtoDTO.getCategoria())));
    }

    public void removerProduto(String id, ProdutoRepositorioAdaptador repositorio) {
        RemoverProdutoUseCase useCase = new RemoverProdutoUseCase(new ProdutoGatewayJPA(repositorio));
        useCase.removerProduto(id);
    }

    public List<ProdutoDTO> buscarProdutosPorCategoria(String categoria, ProdutoRepositorioAdaptador repositorio) {
        BuscarProdutosPorCategoriaUseCase useCase = new BuscarProdutosPorCategoriaUseCase(new ProdutoGatewayJPA(repositorio));
        return ProdutoPresenter.toDTO(useCase.buscarProdutosPorCategoria(valueOf(categoria)));
    }
}
