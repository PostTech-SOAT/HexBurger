package br.com.hexburger.interfaceAdapters.presenter;

import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.interfaceAdapters.dto.ProdutoDTO;

import java.util.List;

public class ProdutoPresenter {

    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(),
                produto.getCategoria());
    }

    public static List<ProdutoDTO> toDTO(List<Produto> produtos) {
        return produtos.stream().map(produto -> new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(),
                produto.getCategoria())).toList();
    }

}
