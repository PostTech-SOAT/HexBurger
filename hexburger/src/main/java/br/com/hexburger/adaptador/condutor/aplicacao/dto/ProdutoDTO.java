package br.com.hexburger.adaptador.condutor.aplicacao.dto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProdutoDTO {

    private String id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private Categoria categoria;

    public Produto toDomain(String id) {
        return new Produto(id, nome, descricao, valor, categoria);
    }

    public Produto toDomain() {
        return new Produto(nome, descricao, valor, categoria);
    }

    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria());
    }
}
