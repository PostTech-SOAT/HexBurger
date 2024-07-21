package br.com.hexburger.framework.entidade;

import br.com.hexburger.dominio.entidade.Combo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Combo")
public class ECombo {

    @Id
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EProdutoPedido> produtosPedido;

    private BigDecimal valorTotal;

    public static ECombo toEntity(Combo combo) {
        return new ECombo(combo.getId(), combo.getProdutos().stream().map(EProdutoPedido::toEntity).toList(), combo.getValorTotal());
    }

    public Combo toDomain() {
        return new Combo(this.getId(), this.getProdutosPedido().stream().map(EProdutoPedido::toDomain).toList(), this.getValorTotal());
    }

}
