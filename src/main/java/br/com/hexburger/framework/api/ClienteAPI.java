package br.com.hexburger.framework.api;

import br.com.hexburger.dominio.util.exception.ConflictException;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;
import br.com.hexburger.interfaceAdapters.dto.ClienteDTO;
import br.com.hexburger.interfaceAdapters.controller.ClienteController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.interfaceAdapters.dto.ClienteDTO.toDTO;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@Tag(name = "Cliente")
@RequiredArgsConstructor
@RequestMapping(value = "/v1/cliente")
public class ClienteAPI {

    private final ClienteController controller;

    @PostMapping
    @Operation(summary = "Criar um cliente")
    public ResponseEntity<Object> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            return ResponseEntity.ok(controller.criarCliente(clienteDTO));
        } catch (IllegalArgumentException e) { //Essa verificação deveria ficar nessa camada ou no presenter?
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (ConflictException e) {
            return new ResponseEntity<>(e.getMessage(), CONFLICT);
        }
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Buscar um cliente por CPF")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable String cpf) {
        try {
            return ResponseEntity.ok(controller.buscarCliente(cpf));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
