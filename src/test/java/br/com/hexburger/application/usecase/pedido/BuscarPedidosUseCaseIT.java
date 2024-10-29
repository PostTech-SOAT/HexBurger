package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.framework.repository.PedidoRepositorioImpl;
import br.com.hexburger.framework.repository.PedidoRepository;
import br.com.hexburger.interfaceadapters.gateway.PedidoGatewayJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@ActiveProfiles("test")
class BuscarPedidosUseCaseIT {

    private BuscarPedidosUseCase useCase;

    @Autowired
    private PedidoRepository repository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {

        openMocks = MockitoAnnotations.openMocks(this);

        PedidoGateway pedidoGateway = new PedidoGatewayJPA(new PedidoRepositorioImpl(repository));

        useCase = new BuscarPedidosUseCase(pedidoGateway);

    }

    @Test
    void deveBuscarPedidos() {

        List<Pedido> pedidos = useCase.buscarPedidos();

        assertThat(pedidos, is(notNullValue()));

    }

}
