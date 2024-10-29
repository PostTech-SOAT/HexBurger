package br.com.hexburger.interfaceadapters.presenter;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.interfaceadapters.dto.PedidoDTO;
import org.junit.jupiter.api.Test;

import static br.com.hexburger.util.ClienteTestUtils.criarCliente;
import static br.com.hexburger.util.PedidoTestUtils.criarCombos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class PedidoPresenterTest {

    @Test
    void deveConverterDeEntidadeParaDTO() {


        Pedido pedido = new Pedido(criarCombos(), criarCliente());

        PedidoDTO pedidoDTO = PedidoPresenter.toDTO(pedido);

        assertThat(pedidoDTO.getId(), is(equalTo(pedido.getId())));
        assertThat(pedidoDTO.getCodigo(), is(equalTo(pedido.getCodigo())));
        assertThat(pedidoDTO.getCombos().size(), is(equalTo(pedido.getCombos().size())));
        assertThat(pedidoDTO.getValorTotal(), is(equalTo(pedido.getValorTotal())));
        assertThat(pedidoDTO.getCliente().getCpf(), is(equalTo(pedido.getCliente().getCpf())));
        assertThat(pedidoDTO.getStatus(), is(equalTo(pedido.getStatus())));
        assertThat(pedidoDTO.getStatusPagamento(), is(equalTo(pedido.getStatusPagamento())));
        assertThat(pedidoDTO.getDataPedido(), is(equalTo(pedido.getDataPedido())));
        assertThat(pedidoDTO.getQrCode(), is(equalTo(pedido.getQrCode())));
        assertThat(pedidoDTO.getIdExternoPagamento(), is(equalTo(pedido.getIdExternoPagamento())));

    }

}
