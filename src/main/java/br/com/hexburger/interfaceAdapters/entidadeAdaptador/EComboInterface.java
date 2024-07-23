package br.com.hexburger.interfaceAdapters.entidadeAdaptador;

import java.math.BigDecimal;
import java.util.List;

public interface EComboInterface {

    String getId();

    List<EProdutoInterface> getProdutosPedido();

    BigDecimal getValorTotal();

}
