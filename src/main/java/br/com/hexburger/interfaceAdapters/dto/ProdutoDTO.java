package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@AllArgsConstructor
public class ProdutoDTO {

    @Schema(accessMode = READ_ONLY)
    private String id;

    @Schema(example = "Hex Burger", requiredMode = REQUIRED)
    private String nome;

    @Schema(example = "Pão e Hambuguer no formato hexagonal", requiredMode = REQUIRED)
    private String descricao;

    @Schema(example = "20", requiredMode = REQUIRED)
    private BigDecimal valor;

    @Schema(example = "LANCHE", requiredMode = REQUIRED)
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
