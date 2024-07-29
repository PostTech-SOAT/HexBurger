package br.com.hexburger.application.interfacegateway;

import br.com.hexburger.application.usecase.pedido.dto.PagamentoResponse;

import java.math.BigDecimal;

public interface ServicoPagamentoGateway {

    PagamentoResponse gerarPagamento(String idPedido, BigDecimal valorTotal);

}
