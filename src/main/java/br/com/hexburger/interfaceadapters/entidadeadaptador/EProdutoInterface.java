package br.com.hexburger.interfaceadapters.entidadeadaptador;

import java.math.BigDecimal;

public interface EProdutoInterface {

    String getId();

    String getNome();

    String getDescricao();

    BigDecimal getValor();

    String getCategoria();
    
}
