package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@AllArgsConstructor
public class PedidoDTO {

    @Schema(accessMode = READ_ONLY)
    private final String id;

    private final List<ComboDTO> combos;

    @Schema(accessMode = READ_ONLY)
    private final BigDecimal valorTotal;

    private final ClienteDTO cliente;

    @Schema(accessMode = READ_ONLY)
    private final StatusPedido status;

    @Schema(accessMode = READ_ONLY)
    private final LocalDateTime dataPedido;

    public Pedido toDomain() {
        return new Pedido(combos.stream().map(ComboDTO::toDomain).toList(), cliente != null ? cliente.toDomain() : null);
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(pedido.getId(), pedido.getCombos().stream().map(ComboDTO::toDTO).toList(), pedido.getValorTotal(),
                pedido.getCliente() != null ? ClienteDTO.toDTO(pedido.getCliente()) : null, pedido.getStatus(), pedido.getDataPedido());
    }
}
