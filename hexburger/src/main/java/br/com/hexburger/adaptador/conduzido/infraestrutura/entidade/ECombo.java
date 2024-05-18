package br.com.hexburger.adaptador.conduzido.infraestrutura.entidade;

import br.com.hexburger.dominio.entidade.Combo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    @ManyToMany
    private List<EProduto> produtos;

    private BigDecimal valorTotal;

    public static ECombo toEntity(Combo combo) {
        return new ECombo(combo.getId(), combo.getProdutos().stream().map(EProduto::toEntity).toList(), combo.getValorTotal());
    }

    public Combo toDomain() {
        return new Combo(this.getId(), this.getProdutos().stream().map(EProduto::toDomain).toList(), this.getValorTotal());
    }

}
