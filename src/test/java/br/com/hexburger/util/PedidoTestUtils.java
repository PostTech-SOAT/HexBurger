package br.com.hexburger.util;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.ProdutoPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PedidoTestUtils {

    public static List<Combo> criarCombos() {

        return List.of(new Combo(criarProdutosPedido()), new Combo(criarProdutosPedido()));

    }

    public static List<ProdutoPedido> criarProdutosPedido() {

        return List.of(
                new ProdutoPedido(UUID.randomUUID().toString(), "Hex Burger", "Pão e Hambuguer no formato hexagonal", BigDecimal.valueOf(15.00), Categoria.LANCHE),
                new ProdutoPedido(UUID.randomUUID().toString(), "Hex Fries", "Batatas fritas crocantes", BigDecimal.valueOf(8.00), Categoria.ACOMPANHAMENTO),
                new ProdutoPedido(UUID.randomUUID().toString(), "Água", "Água", BigDecimal.valueOf(4.00), Categoria.BEBIDA),
                new ProdutoPedido(UUID.randomUUID().toString(), "Hex Gelatto", "Sorvete de creme 200ml", BigDecimal.valueOf(15.00), Categoria.SOBREMESA)
        );

    }

}
