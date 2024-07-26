package br.com.hexburger.interfaceAdapters.entidadeAdaptador;

import java.math.BigDecimal;

public interface EProdutoInterface {

    String getId();

    String getNome();

    String getDescricao();

    BigDecimal getValor();

    String getCategoria();
    
}
