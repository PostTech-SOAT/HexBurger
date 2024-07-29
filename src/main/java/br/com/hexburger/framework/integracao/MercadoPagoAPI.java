package br.com.hexburger.framework.integracao;

import br.com.hexburger.application.interfacegateway.ServicoPagamentoGateway;
import br.com.hexburger.application.usecase.pedido.dto.PagamentoResponse;
import br.com.hexburger.framework.integracao.dto.PagamentoRequestDTO;
import br.com.hexburger.framework.integracao.dto.PagamentoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class MercadoPagoAPI implements ServicoPagamentoGateway {

    public PagamentoResponse gerarPagamento(String idPedido, BigDecimal valorTotal) {
        ResponseEntity<PagamentoResponseDTO> responseEntity = new RestTemplate().postForEntity("https://hexburguer.app.n8n.cloud/webhook/gerar-qr-code-pagamento",
                new PagamentoRequestDTO(idPedido, valorTotal), PagamentoResponseDTO.class);
        return responseEntity.getBody();
    }

}
