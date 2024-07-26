package br.com.hexburger.interfaceAdapters.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

public class ComboDTO {

    @Schema(accessMode = READ_ONLY)
    private final String id;

    private final List<ProdutoPedidoDTO> produtos;

    @Schema(accessMode = READ_ONLY)
    private final BigDecimal valorTotal;

    public ComboDTO(String id, List<ProdutoPedidoDTO> produtos, BigDecimal valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public List<ProdutoPedidoDTO> getProdutos() {
        return produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}
