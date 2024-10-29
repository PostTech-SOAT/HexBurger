package br.com.hexburger.application.usecase.pedido;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.application.interfacegateway.ProdutoGateway;
import br.com.hexburger.application.interfacegateway.ServicoPagamentoGateway;
import br.com.hexburger.application.usecase.pedido.dto.PagamentoResponse;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Combo;
import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.dominio.entidade.ProdutoPedido;
import br.com.hexburger.framework.integracao.dto.PagamentoResponseDTO;
import br.com.hexburger.framework.repository.PedidoRepositorioImpl;
import br.com.hexburger.framework.repository.PedidoRepository;
import br.com.hexburger.framework.repository.ProdutoRepositorioImpl;
import br.com.hexburger.framework.repository.ProdutoRepository;
import br.com.hexburger.interfaceadapters.gateway.PedidoGatewayJPA;
import br.com.hexburger.interfaceadapters.gateway.ProdutoGatewayJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static br.com.hexburger.util.ClienteTestUtils.criarCliente;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class CriarPedidoUseCaseIT {

    private CriarPedidoUseCase useCase;

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Mock
    private ServicoPagamentoGateway servicoPagamentoGateway;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {

        openMocks = MockitoAnnotations.openMocks(this);

        PedidoGateway pedidoGateway = new PedidoGatewayJPA(new PedidoRepositorioImpl(repository));
        ProdutoGateway produtoGateway = new ProdutoGatewayJPA(new ProdutoRepositorioImpl(produtoRepository));

        useCase = new CriarPedidoUseCase(pedidoGateway, produtoGateway, servicoPagamentoGateway);

    }

    @Test
    void deveCriarPedido() {

        Pedido pedido = new Pedido(criarCombos(), criarCliente());
        PagamentoResponse pagamentoResponse = new PagamentoResponseDTO("qrCode", "idExterno");

        when(servicoPagamentoGateway.gerarPagamento(any(String.class), any(BigDecimal.class))).thenReturn(pagamentoResponse);

        Pedido pedidoCriado = useCase.criarPedido(pedido);

        assertThat(pedidoCriado, is(notNullValue()));
        assertThat(pedidoCriado.getId(), is(equalTo(pedido.getId())));
        assertThat(pedidoCriado.getCliente().getCpf(), is(equalTo(pedido.getCliente().getCpf())));
        assertThat(pedidoCriado.getCombos().size(), is(equalTo(pedido.getCombos().size())));
        assertThat(pedidoCriado.getStatus(), is(equalTo(pedido.getStatus())));
        assertThat(pedidoCriado.getValorTotal(), is(equalTo(pedido.getValorTotal())));
        assertThat(pedidoCriado.getDataPedido(), is(equalTo(pedido.getDataPedido())));
        assertThat(pedidoCriado.getQrCode(), is(equalTo(pedido.getQrCode())));
        assertThat(pedidoCriado.getStatusPagamento(), is(equalTo(pedido.getStatusPagamento())));


    }

    @Test
    void deveLancarExcecaoAoCriarPedidoInvalido() {

        Pedido pedidoSemCombos = new Pedido(List.of(), criarCliente());
        PagamentoResponse pagamentoResponse = new PagamentoResponseDTO("qrCode", "idExterno");

        when(servicoPagamentoGateway.gerarPagamento(any(String.class), any(BigDecimal.class))).thenReturn(pagamentoResponse);

        assertThrows(IllegalArgumentException.class, () -> useCase.criarPedido(pedidoSemCombos));

    }

    private static List<Combo> criarCombos() {

        return List.of(new Combo(criarProdutosPedido()), new Combo(criarProdutosPedido()));

    }

    private static List<ProdutoPedido> criarProdutosPedido() {

        return List.of(
                new ProdutoPedido("5c4c83cb-f1e8-4182-8601-281323f00111", "Hex Burger", "Pão e Hambuguer no formato hexagonal", BigDecimal.valueOf(15.00), Categoria.LANCHE),
                new ProdutoPedido("f55f733e-aeb3-4955-87d7-b521895cae80", "Hex Fries", "Batatas fritas crocantes", BigDecimal.valueOf(8.00), Categoria.ACOMPANHAMENTO),
                new ProdutoPedido("a1fe5443-3bc7-4cb0-8ffe-a1dc0bf8768c", "Água", "Água", BigDecimal.valueOf(4.00), Categoria.BEBIDA),
                new ProdutoPedido("7cbc859a-a702-4f64-9f81-2136c338338c", "Hex Gelatto", "Sorvete de creme 200ml", BigDecimal.valueOf(15.00), Categoria.SOBREMESA)
        );

    }

}
