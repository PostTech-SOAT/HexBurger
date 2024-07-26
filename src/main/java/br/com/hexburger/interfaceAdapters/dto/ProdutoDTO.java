package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Categoria;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String id;

    private final String nome;

    private final String descricao;

    private final BigDecimal valor;

    private final Categoria categoria;


    public ProdutoDTO(String id, String nome, String descricao, BigDecimal valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
