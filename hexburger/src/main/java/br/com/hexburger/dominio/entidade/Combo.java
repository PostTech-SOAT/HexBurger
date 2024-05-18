package br.com.hexburger.dominio.entidade;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.frequency;
import static org.springframework.util.CollectionUtils.isEmpty;

public class Combo {

    private final String id;

    private final List<Produto> produtos;

    private final BigDecimal valorTotal;

    public Combo(String id, List<Produto> produtos, BigDecimal valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Combo(List<Produto> produtos) {
        this.id = UUID.randomUUID().toString();
        this.produtos = produtos;
        this.valorTotal = produtos.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        validaCombo();
    }

    public String getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    private void validaCombo() {
        if (!validaProdutos() || !validaValorTotal()) {
            throw new IllegalArgumentException("Combo inválido");
        }
    }

    private boolean validaProdutos() {
        List<Categoria> categorias = produtos.stream().map(Produto::getCategoria).toList();
        return !isEmpty(produtos) && categorias.stream().noneMatch(categoria -> frequency(categorias, categoria) > 1);
    }

    private boolean validaValorTotal() {
        return valorTotal != null && valorTotal.compareTo(BigDecimal.ZERO) > 0;
    }
}
