package br.com.hexburger.adaptador.condutor.aplicacao.dto;

import br.com.hexburger.dominio.entidade.Combo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ComboDTO {

    private final String id;

    private final List<ProdutoDTO> produtos;

    private final BigDecimal valorTotal;

    public Combo toDomain() {
        return new Combo(produtos.stream().map(produto -> produto.toDomain(produto.getId())).toList());
    }

    public static ComboDTO toDTO(Combo combo) {
        return new ComboDTO(combo.getId(), combo.getProdutos().stream().map(ProdutoDTO::toDTO).toList(), combo.getValorTotal());
    }
}
