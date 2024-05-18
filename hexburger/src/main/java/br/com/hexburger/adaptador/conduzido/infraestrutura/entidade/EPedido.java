package br.com.hexburger.adaptador.conduzido.infraestrutura.entidade;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPedido;
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
public class EPedido {

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
                combo.getValorTotal(), combo.getCliente() != null ? ECliente.toEntity(combo.getCliente()) : null, combo.getStatus(), combo.getDataPedido());
    }

    public Pedido toDomain() {
        return new Pedido(this.getId(), this.getCombos().stream().map(ECombo::toDomain).toList(), this.getValorTotal(),
                this.getCliente() != null ? this.getCliente().toDomain() : null, this.getStatus(), this.getDataPedido());
    }

}
