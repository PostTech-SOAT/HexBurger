package br.com.hexburger.adaptador.conduzido.infraestrutura.entidade;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produto")
public class EProduto {

    @Id
    private String id;

    @Column(unique = true)
    private String nome;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(STRING)
    private Categoria categoria;

    public static EProduto toEntity(Produto produto) {
        return new EProduto(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria());
    }

    public Produto toDomain() {
        return new Produto(this.getId(), this.getNome(), this.getDescricao(), this.getValor(), this.getCategoria());
    }
}
