package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@AllArgsConstructor
public class ProdutoPedidoDTO {

    @Schema(example = "99f79c3b-15a2-40d2-87c5-83275815f3f5", requiredMode = REQUIRED)
    private String id;

    @Schema(accessMode = READ_ONLY)
    private String nome;

    @Schema(accessMode = READ_ONLY)
    private String descricao;

    @Schema(accessMode = READ_ONLY)
    private BigDecimal valor;

    @Schema(accessMode = READ_ONLY)
    private Categoria categoria;

    public ProdutoPedido toDomain(String id) {
        return new ProdutoPedido(id);
    }

    public static ProdutoPedidoDTO toDTO(ProdutoPedido produtoPedido) {
        return new ProdutoPedidoDTO(produtoPedido.getId(), produtoPedido.getNome(), produtoPedido.getDescricao(), produtoPedido.getValor(), produtoPedido.getCategoria());
    }
}
