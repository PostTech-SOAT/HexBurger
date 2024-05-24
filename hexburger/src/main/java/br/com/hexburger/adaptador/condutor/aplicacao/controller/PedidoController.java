package br.com.hexburger.adaptador.condutor.aplicacao.controller;

import br.com.hexburger.adaptador.condutor.aplicacao.dto.PedidoDTO;
import br.com.hexburger.dominio.porta.entrada.PedidoPortaAplicacao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.adaptador.condutor.aplicacao.dto.PedidoDTO.toDTO;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/pedido")
public class PedidoController {

    private final PedidoPortaAplicacao pedidoPortaAplicacao;

    @PostMapping
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        try {
            return ResponseEntity.ok(toDTO(pedidoPortaAplicacao.criarPedido(pedidoDTO.toDomain())));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Object> buscarPedidos() {
        return ResponseEntity.ok(pedidoPortaAplicacao.buscarPedidos().stream().map(PedidoDTO::toDTO).toList());
    }
}
