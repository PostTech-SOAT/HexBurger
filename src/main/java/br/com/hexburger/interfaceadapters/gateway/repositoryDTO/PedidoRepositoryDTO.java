package br.com.hexburger.interfaceadapters.gateway.repositoryDTO;

import br.com.hexburger.dominio.entidade.StatusPagamento;
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

    private StatusPagamento statusPagamento;

    private LocalDateTime dataPedido;

    private String qrCode;

    private String idExternoPagamento;

    public PedidoRepositoryDTO(String id, List<ComboRepositoryDTO> combos, BigDecimal valorTotal, ClienteRepositoryDTO cliente, StatusPedido status, StatusPagamento statusPagamento, LocalDateTime dataPedido, String qrCode, String idExternoPagamento) {
        this.id = id;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.dataPedido = dataPedido;
        this.qrCode = qrCode;
        this.idExternoPagamento = idExternoPagamento;
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

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public String getQrCode() {
        return qrCode;
    }

    public String getIdExternoPagamento() {
        return idExternoPagamento;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
