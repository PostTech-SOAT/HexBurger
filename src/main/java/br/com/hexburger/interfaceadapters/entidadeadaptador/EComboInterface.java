package br.com.hexburger.interfaceadapters.entidadeadaptador;

import java.math.BigDecimal;
import java.util.List;

public interface EComboInterface {

    String getId();

    List<? extends EProdutoPedidoInterface> getProdutosPedido();

    BigDecimal getValorTotal();

}
