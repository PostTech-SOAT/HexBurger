package br.com.hexburger.framework.api;

import br.com.hexburger.framework.repository.PedidoRepositorioImpl;
import br.com.hexburger.interfaceadapters.controller.PedidoController;
import br.com.hexburger.interfaceadapters.dto.PagamentoDTO;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/pagamento")
public class PagamentoAPI {

    private final PedidoRepositorioImpl pedidoRepositorio;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusDoPagamentoDoPedido(@RequestBody PagamentoDTO pagamentoDTO) {
        PedidoController controller = new PedidoController();
        controller.atualizarStatusDoPagamento(pagamentoDTO, pedidoRepositorio);
        return ResponseEntity.accepted().build();
    }

}
