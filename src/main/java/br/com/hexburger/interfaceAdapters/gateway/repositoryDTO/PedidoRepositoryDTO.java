package br.com.hexburger.interfaceAdapters.gateway.repositoryDTO;

import br.com.hexburger.dominio.entidade.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoRepositoryDTO {

    private String id;

    private Integer codigo;

    private List<ComboRepositoryDTO> combos;

    private BigDecimal valorTotal;

    private ClienteRepositoryDTO cliente;

    private StatusPedido status;

    private LocalDateTime dataPedido;

    public PedidoRepositoryDTO(String id, List<ComboRepositoryDTO> combos, BigDecimal valorTotal, ClienteRepositoryDTO cliente, StatusPedido status, LocalDateTime dataPedido) {
        this.id = id;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.status = status;
        this.dataPedido = dataPedido;
    }

    public String getId() {
        return id;
    }

    public List<ComboRepositoryDTO> getCombos() {
        return combos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ClienteRepositoryDTO getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
}
