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

    public PedidoRepositoryDTO(String id, Integer codigo, List<ComboRepositoryDTO> combos, BigDecimal valorTotal, ClienteRepositoryDTO cliente, StatusPedido status, LocalDateTime dataPedido) {
        this.id = id;
        this.codigo = codigo;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.status = status;
        this.dataPedido = dataPedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<ComboRepositoryDTO> getCombos() {
        return combos;
    }

    public void setCombos(List<ComboRepositoryDTO> combos) {
        this.combos = combos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ClienteRepositoryDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRepositoryDTO cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
}
