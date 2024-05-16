package br.com.hexburger.adaptador.condutor.aplicacao.controller;

import br.com.hexburger.adaptador.condutor.aplicacao.dto.ClienteDTO;
import br.com.hexburger.dominio.porta.entrada.cliente.CriarClientePortaAplicacao;
import br.com.hexburger.dominio.porta.entrada.cliente.EncontrarClientePortaAplicacao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.adaptador.condutor.aplicacao.dto.ClienteDTO.toDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final CriarClientePortaAplicacao criarClientePortaAplicacao;
    private final EncontrarClientePortaAplicacao encontrarClientePortaAplicacao;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(toDTO(criarClientePortaAplicacao.criarCliente(clienteDTO.toDominio())));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> encontrarCliente(@PathVariable String cpf) {
        return ResponseEntity.ok(toDTO(encontrarClientePortaAplicacao.encontrarCliente(cpf)));
    }
}
