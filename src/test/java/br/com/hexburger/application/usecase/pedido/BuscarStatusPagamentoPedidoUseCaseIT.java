package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.StatusPagamento;
import br.com.hexburger.framework.repository.PedidoRepositorioImpl;
import br.com.hexburger.framework.repository.PedidoRepository;
import br.com.hexburger.interfaceadapters.gateway.PedidoGatewayJPA;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@ActiveProfiles("test")
class BuscarStatusPagamentoPedidoUseCaseIT {

    private BuscarStatusPagamentoPedidoUseCase useCase;

    @Autowired
    private PedidoRepository repository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {

        openMocks = MockitoAnnotations.openMocks(this);

        PedidoGateway pedidoGateway = new PedidoGatewayJPA(new PedidoRepositorioImpl(repository));

        useCase = new BuscarStatusPagamentoPedidoUseCase(pedidoGateway);

    }

    @Test
    void deveBuscarStatusPagamentoPedido() {

        String statusPagamento = useCase.buscarStatusPagamentoPedido("9c3e7112-ac5c-413a-9e24-22688bf60976");

        assertThat(statusPagamento, is(Matchers.notNullValue()));
        assertThat(statusPagamento, is(equalTo(StatusPagamento.AGUARDANDO.name())));

    }

}
