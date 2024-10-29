package br.com.hexburger.framework.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class PedidoRepositorioImplIT {

    @Autowired
    private PedidoRepository repository;

    private PedidoRepositorioImpl pedidoRepositorio;

    @BeforeEach
    void setup() {

        pedidoRepositorio = new PedidoRepositorioImpl(repository);

    }

    @Test
    void deveCriarPedido() {

    }

    @Test
    void deveBuscarPedidos() {

    }

    @Test
    void deveBuscarStatusPagamentoPedido() {

    }

    @Test
    void deveAtualizarStatusPagamento() {

    }

    @Test
    void deveAtualizarStatusPedido() {

    }

}
