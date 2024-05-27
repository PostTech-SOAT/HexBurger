package br.com.hexburger.dominio.entidade;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

public class Produto {

    private final String id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private Categoria categoria;

    public Produto(String id, String nome, String descricao, BigDecimal valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        validaProduto();
    }

    public Produto(String nome, String descricao, BigDecimal valor, Categoria categoria) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        validaProduto();
    }

    public Produto(String id) {
        this.id = id;
        this.valor = BigDecimal.ZERO;
    }

    public String getId() {
        return id;
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

    private void validaProduto() {
        if (!validaNome() || !validaDescricao() || !validaValor() || !validaCategoria()) {
            throw new IllegalArgumentException("Produto inválido");
        }
    }

    private boolean validaNome() {
        return !isEmpty(nome);
    }

    private boolean validaDescricao() {
        return !isEmpty(descricao);
    }

    private boolean validaValor() {
        return valor != null && valor.compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean validaCategoria() {
        return categoria != null;
    }

}
