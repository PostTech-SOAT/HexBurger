package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

    private final String id;

    private final Integer codigo;

    private final List<ComboDTO> combos;

    private final BigDecimal valorTotal;

    private final ClienteDTO cliente;

    private final StatusPedido status;

    private final LocalDateTime dataPedido;

    public PedidoDTO(String id, Integer codigo, List<ComboDTO> combos, BigDecimal valorTotal, ClienteDTO cliente, StatusPedido status, LocalDateTime dataPedido) {
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

    public Integer getCodigo() {
        return codigo;
    }

    public List<ComboDTO> getCombos() {
        return combos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

}
