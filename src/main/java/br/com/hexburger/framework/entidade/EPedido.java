package br.com.hexburger.framework.entidade;

import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EPedidoInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.generator.EventType;

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

    @Generated
    @Column(columnDefinition = "serial", updatable = false)
    private Integer codigo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ECombo> combos;

    private BigDecimal valorTotal;

    @ManyToOne
    private ECliente cliente;

    private String status;

    private LocalDateTime dataPedido;

    public EPedido(String id, List<ECombo> combos, BigDecimal valorTotal, ECliente cliente, String status, LocalDateTime dataPedido) {
        this.id = id;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.status = status;
        this.dataPedido = dataPedido;
    }

}
