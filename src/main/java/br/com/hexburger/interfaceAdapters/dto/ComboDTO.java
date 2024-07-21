package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Combo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@AllArgsConstructor
public class ComboDTO {

    @Schema(accessMode = READ_ONLY)
    private final String id;

    private final List<ProdutoPedidoDTO> produtos;

    @Schema(accessMode = READ_ONLY)
    private final BigDecimal valorTotal;

    public Combo toDomain() {
        return new Combo(produtos.stream().map(produto -> produto.toDomain(produto.getId())).toList());
    }

    public static ComboDTO toDTO(Combo combo) {
        return new ComboDTO(combo.getId(), combo.getProdutos().stream().map(ProdutoPedidoDTO::toDTO).toList(), combo.getValorTotal());
    }
}
