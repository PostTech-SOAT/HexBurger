package br.com.hexburger.adaptador.condutor.aplicacao.dto;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoDTO {

    private final String id;

    private final List<ComboDTO> combos;

    private final BigDecimal valorTotal;

    private final ClienteDTO cliente;

    private final StatusPedido status;

    private final LocalDateTime dataPedido;

    public Pedido toDominio() {
        return new Pedido(combos.stream().map(ComboDTO::toDominio).toList(), cliente != null ? cliente.toDominio() : null);
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(pedido.getId(), pedido.getCombos().stream().map(ComboDTO::toDTO).toList(), pedido.getValorTotal(),
                pedido.getCliente() != null ? ClienteDTO.toDTO(pedido.getCliente()) : null, pedido.getStatus(), pedido.getDataPedido());
    }
}
