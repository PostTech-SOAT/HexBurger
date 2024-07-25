package br.com.hexburger.interfaceAdapters.entidadeAdaptador;

import java.math.BigDecimal;

public interface EProdutoPedidoInterface {

    String getId();

    String getNome();

    String getDescricao();

    BigDecimal getValor();

    String getCategoria();

}
