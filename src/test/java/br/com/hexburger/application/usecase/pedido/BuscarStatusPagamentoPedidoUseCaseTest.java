package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarStatusPagamentoPedidoUseCaseTest {

    private BuscarStatusPagamentoPedidoUseCase useCase;

    @Mock
    private PedidoGateway pedidoGateway;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {

        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new BuscarStatusPagamentoPedidoUseCase(pedidoGateway);

    }

    @Test
    void deveBuscarStatusPagamentoPedido() {

        when(pedidoGateway.buscarStatusPagamentoPedido(any(String.class))).thenReturn(Optional.of("Pago"));

        String statusPagamento = useCase.buscarStatusPagamentoPedido("2e45fe6b-709b-484f-904e-caaaa13f7b45");

        assertThat(statusPagamento, is(notNullValue()));
        assertThat(statusPagamento, is(equalTo("Pago")));

    }

    @Test
    void deveLancarExcecaoAoBuscarStatusDePedidoInexistente() {

        when(pedidoGateway.buscarStatusPagamentoPedido(any(String.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> useCase.buscarStatusPagamentoPedido("e04073e9-15d9-4af5-8ec6-5bb05f325566"));

        assertThat(exception.getMessage(), is(equalTo("Pedido não encontrado")));

    }

}
