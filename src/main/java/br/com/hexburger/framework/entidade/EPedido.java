package br.com.hexburger.framework.entidade;

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

    private String status;

    private LocalDateTime dataPedido;

}
