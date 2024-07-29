package br.com.hexburger.interfaceadapters.entidadeadaptador;

import java.math.BigDecimal;

public interface EProdutoPedidoInterface {

    String getId();

    String getNome();

    String getDescricao();

    BigDecimal getValor();

    String getCategoria();

}
