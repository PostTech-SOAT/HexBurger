package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.hexburger.dominio.entidade.StatusPagamento.APROVADO;
import static br.com.hexburger.dominio.entidade.StatusPagamento.RECUSADO;
import static br.com.hexburger.dominio.entidade.StatusPedido.CANCELADO;
import static br.com.hexburger.dominio.entidade.StatusPedido.EM_PREPARACAO;
import static br.com.hexburger.util.ClienteTestUtils.criarCliente;
import static br.com.hexburger.util.PedidoTestUtils.criarCombos;
import static org.mockito.Mockito.verify;

class AtualizarStatusPagamentoPedidoUseCaseTest {

    private AtualizarStatusPagamentoPedidoUseCase useCase;

    @Mock
    private PedidoGateway pedidoGateway;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {

        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new AtualizarStatusPagamentoPedidoUseCase(pedidoGateway);

    }

    @Test
    void deveAtualizarStatusPagamentoAprovado() {

        Pedido pedido = new Pedido(criarCombos(), criarCliente());

        useCase.atualizarStatusPagamento(pedido.getId(), pedido.getIdExternoPagamento(), true);

        verify(pedidoGateway).atualizarStatusPagamento(pedido.getId(), pedido.getIdExternoPagamento(), APROVADO);
        verify(pedidoGateway).atualizarStatusPedido(pedido.getId(), EM_PREPARACAO);

    }

    @Test
    void deveAtualizarStatusPagamentoRecusado() {

        Pedido pedido = new Pedido(criarCombos(), criarCliente());

        useCase.atualizarStatusPagamento(pedido.getId(), pedido.getIdExternoPagamento(), false);

        verify(pedidoGateway).atualizarStatusPagamento(pedido.getId(), pedido.getIdExternoPagamento(), RECUSADO);
        verify(pedidoGateway).atualizarStatusPedido(pedido.getId(), CANCELADO);

    }

}
