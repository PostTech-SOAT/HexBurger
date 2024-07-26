package br.com.hexburger.interfaceAdapters.entidadeAdaptador;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface EPedidoInterface {

    String getId();

    List<? extends EComboInterface> getCombos();

    BigDecimal getValorTotal();

    EClienteInterface getCliente();

    String getStatus();

    LocalDateTime getDataPedido();

}
