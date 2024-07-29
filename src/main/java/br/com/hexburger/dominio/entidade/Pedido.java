package br.com.hexburger.dominio.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.hexburger.dominio.entidade.StatusPagamento.AGUARDANDO;
import static br.com.hexburger.dominio.entidade.StatusPedido.RECEBIDO;
import static java.time.LocalDateTime.now;

public class Pedido {

    private final String id;

    private Integer codigo;

    private List<Combo> combos;

    private BigDecimal valorTotal;

    private final Cliente cliente;

    private final StatusPedido status;

    private final StatusPagamento statusPagamento;

    private final LocalDateTime dataPedido;

    private String qrCode;

    private String idExternoPagamento;

    public Pedido(List<Combo> combos, Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.combos = combos;
        this.valorTotal = combos.stream().map(Combo::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.cliente = cliente;
        this.status = RECEBIDO;
        this.statusPagamento = AGUARDANDO;
        this.dataPedido = now();
    }

    public Pedido(String id, Integer codigo, List<Combo> combos, BigDecimal valorTotal, Cliente cliente, StatusPedido status,
                  StatusPagamento statusPagamento, LocalDateTime dataPedido, String qrCode, String idExternoPagamento) {
        this.id = id;
        this.codigo = codigo;
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

    public Integer getCodigo() {
        return codigo;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
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

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
        this.valorTotal = combos.stream().map(Combo::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setIdExternoPagamento(String idExternoPagamento) {
        this.idExternoPagamento = idExternoPagamento;
    }

    public void validaPedido() {
        if (!validaCombos() || !validaValorTotal()) {
            throw new IllegalArgumentException("Pedido inválido");
        }
        combos.forEach(Combo::validaCombo);
    }

    private boolean validaCombos() {
        return combos != null && !combos.isEmpty();
    }

    private boolean validaValorTotal() {
        return valorTotal != null && valorTotal.compareTo(BigDecimal.ZERO) > 0;
    }

    public void setInformacoesPagamento(String qrCode, String idExterno) {
        this.setQrCode(qrCode);
        this.setIdExternoPagamento(idExterno);
    }
}
