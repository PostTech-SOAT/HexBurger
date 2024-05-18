package br.com.hexburger.dominio.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.hexburger.dominio.entidade.StatusPedido.RECEBIDO;
import static java.time.LocalDateTime.now;
import static org.springframework.util.CollectionUtils.isEmpty;

public class Pedido {

    private final String id;

    private final List<Combo> combos;

    private final BigDecimal valorTotal;

    private final Cliente cliente;

    private final StatusPedido status;

    private final LocalDateTime dataPedido;

    public Pedido(List<Combo> combos, Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.combos = combos;
        this.valorTotal = combos.stream().map(Combo::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.cliente = cliente;
        this.status = RECEBIDO;
        this.dataPedido = now();
        validaPedido();
    }

    public Pedido(String id, List<Combo> combos, BigDecimal valorTotal, Cliente cliente, StatusPedido status, LocalDateTime dataPedido) {
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

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    private void validaPedido() {
        if (!validaCombos() || !validaValorTotal()) {
            throw new IllegalArgumentException("Pedido inválido");
        }
    }

    private boolean validaCombos() {
        return !isEmpty(combos);
    }

    private boolean validaValorTotal() {
        return valorTotal != null && valorTotal.compareTo(BigDecimal.ZERO) > 0;
    }
}
