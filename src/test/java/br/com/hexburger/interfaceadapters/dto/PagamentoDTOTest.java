package br.com.hexburger.interfaceadapters.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PagamentoDTOTest {

    @Test
    void deveCriarPagamentoAprovado() {

        PagamentoDTO pagamento = new PagamentoDTO("Aprovado", UUID.randomUUID().toString(), BigDecimal.valueOf(21.00), UUID.randomUUID().toString());

        assertThat(pagamento, is(notNullValue()));
        assertThat(pagamento.getIdPedido(), is(notNullValue()));
        assertThat(pagamento.isAprovado(), is(true));
        assertThat(pagamento.getTotalPago(), is(BigDecimal.valueOf(21.00)));
        assertThat(pagamento.getIdExternoPagamento(), is(notNullValue()));

    }

    @Test
    void deveCriarPagamentoNaoAprovado() {

        PagamentoDTO pagamento = new PagamentoDTO("Recusado", UUID.randomUUID().toString(), BigDecimal.valueOf(21.00), UUID.randomUUID().toString());

        assertThat(pagamento, is(notNullValue()));
        assertThat(pagamento.getIdPedido(), is(notNullValue()));
        assertThat(pagamento.isAprovado(), is(false));
        assertThat(pagamento.getTotalPago(), is(BigDecimal.valueOf(21.00)));
        assertThat(pagamento.getIdExternoPagamento(), is(notNullValue()));

    }

}
