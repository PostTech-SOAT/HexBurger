package br.com.hexburger.framework.api;

import br.com.hexburger.framework.repository.ClienteRepositorioImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ClienteAPITest {

    private MockMvc mockMvc;

    @Mock
    private ClienteRepositorioImpl repositorio;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {

        openMocks = MockitoAnnotations.openMocks(this);
        ClienteAPI clienteAPI = new ClienteAPI(repositorio);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteAPI)
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();

    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveCriarCliente() {

    }

}
