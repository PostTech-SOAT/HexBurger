package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.StatusPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.hexburger.util.ClienteTestUtils.criarCliente;
import static br.com.hexburger.util.PedidoTestUtils.criarCombos;
import static org.mockito.Mockito.verify;

class AtualizarStatusPedidoUseCaseTest {

    private AtualizarStatusPedidoUseCase useCase;

    @Mock
    private PedidoGateway pedidoGateway;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {

        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new AtualizarStatusPedidoUseCase(pedidoGateway);

    }

    @Test
    void deveAtualizarStatusPedido() {

        Pedido pedido = new Pedido(criarCombos(), criarCliente());

        useCase.atualizarStatusPedido(pedido.getId(), StatusPedido.RECEBIDO);

        verify(pedidoGateway).atualizarStatusPedido(pedido.getId(), StatusPedido.RECEBIDO);

    }

}
