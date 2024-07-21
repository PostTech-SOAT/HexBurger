package br.com.hexburger.framework.api;

import br.com.hexburger.interfaceAdapters.dto.PedidoDTO;
import br.com.hexburger.interfaceAdapters.controller.PedidoController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.interfaceAdapters.dto.PedidoDTO.toDTO;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@Tag(name = "Pedido")
@RequiredArgsConstructor
@RequestMapping(value = "/v1/pedido")
public class PedidoAPI {

    private final PedidoController controller;

    @PostMapping
    @Operation(summary = "Criar um pedido")
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        try {
            return ResponseEntity.ok(toDTO(controller.criarPedido(pedidoDTO.toDomain())));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Buscar todos os pedidos")
    public ResponseEntity<Object> buscarPedidos() {
        return ResponseEntity.ok(controller.buscarPedidos().stream().map(PedidoDTO::toDTO).toList());
    }

    //checkout -> Para chamar API do mercado pago, chamar nessa camada?
}
