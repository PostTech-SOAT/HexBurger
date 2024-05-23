package br.com.hexburger.adaptador.condutor.aplicacao.controller;

import br.com.hexburger.adaptador.condutor.aplicacao.dto.PedidoDTO;
import br.com.hexburger.dominio.porta.entrada.pedido.BuscarPedidosPortaAplicacao;
import br.com.hexburger.dominio.porta.entrada.pedido.CriarPedidoPortaAplicacao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.adaptador.condutor.aplicacao.dto.PedidoDTO.toDTO;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/pedido")
public class PedidoController {

    private final CriarPedidoPortaAplicacao criarPedidoPortaAplicacao;
    private final BuscarPedidosPortaAplicacao buscarPedidosPortaAplicacao;

    @PostMapping
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        try {
            return ResponseEntity.ok(toDTO(criarPedidoPortaAplicacao.criarPedido(pedidoDTO.toDomain())));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Object> buscarPedidos() {
        return ResponseEntity.ok(buscarPedidosPortaAplicacao.buscarPedidos().stream().map(PedidoDTO::toDTO).toList());
    }
}
