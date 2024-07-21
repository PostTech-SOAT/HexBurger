package br.com.hexburger.framework.entidade;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProdutoPedido")
public class EProdutoPedido {

    @Id
    private String id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(STRING)
    private Categoria categoria;

    public static EProdutoPedido toEntity(ProdutoPedido produtoPedido) {
        return new EProdutoPedido(produtoPedido.getId(), produtoPedido.getNome(), produtoPedido.getDescricao(), produtoPedido.getValor(), produtoPedido.getCategoria());
    }

    public ProdutoPedido toDomain() {
        return new ProdutoPedido(this.getId(), this.getNome(), this.getDescricao(), this.getValor(), this.getCategoria());
    }

}
