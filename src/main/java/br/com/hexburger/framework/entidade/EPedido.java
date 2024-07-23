package br.com.hexburger.framework.entidade;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPedido;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EPedidoInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pedido")
public class EPedido implements EPedidoInterface {

    @Id
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ECombo> combos;

    private BigDecimal valorTotal;

    @ManyToOne
    private ECliente cliente;

    private StatusPedido status;

    private LocalDateTime dataPedido;

    public static EPedido toEntity(Pedido combo) {
        return new EPedido(combo.getId(), combo.getCombos().stream().map(ECombo::toEntity).toList(),
                combo.getValorTotal(), combo.getCliente() != null ? new ECliente(combo.getCliente().getCpf(), combo.getCliente().getNome(), combo.getCliente().getEmail()) : null, combo.getStatus(), combo.getDataPedido());
    }

    public Pedido toDomain() { //todo -> Remover
        return new Pedido(this.getId(), this.getCombos().stream().map(ECombo::toDomain).toList(), this.getValorTotal(),
                null, this.getStatus(), this.getDataPedido());
    }

}
