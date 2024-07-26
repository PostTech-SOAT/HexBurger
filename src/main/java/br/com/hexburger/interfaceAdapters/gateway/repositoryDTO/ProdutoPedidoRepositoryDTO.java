package br.com.hexburger.interfaceAdapters.gateway.repositoryDTO;

import br.com.hexburger.dominio.entidade.Categoria;

import java.math.BigDecimal;

public class ProdutoPedidoRepositoryDTO {

    private String id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private Categoria categoria;

    public ProdutoPedidoRepositoryDTO(String id, String nome, String descricao, BigDecimal valor, Categoria categoria) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
