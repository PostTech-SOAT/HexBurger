package br.com.hexburger.interfaceAdapters.gateway.repositoryDTO;

import java.math.BigDecimal;
import java.util.List;

public class ComboRepositoryDTO {

    private String id;

    private List<ProdutoPedidoRepositoryDTO> produtos;

    private BigDecimal valorTotal;

    public ComboRepositoryDTO(String id, List<ProdutoPedidoRepositoryDTO> produtos, BigDecimal valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProdutoPedidoRepositoryDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedidoRepositoryDTO> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
