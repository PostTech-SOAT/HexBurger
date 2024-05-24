package br.com.hexburger.adaptador.condutor.aplicacao.controller;

import br.com.hexburger.adaptador.condutor.aplicacao.dto.ProdutoDTO;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.porta.entrada.ProdutoPortaAplicacao;
import br.com.hexburger.dominio.util.exception.ConflictException;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.hexburger.adaptador.condutor.aplicacao.dto.ProdutoDTO.toDTO;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/produto")
public class ProdutoController {

    private final ProdutoPortaAplicacao produtoPortaAplicacao;

    @PostMapping
    public ResponseEntity<Object> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            return ResponseEntity.ok(toDTO(produtoPortaAplicacao.criarProduto(produtoDTO.toDomain())));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (ConflictException e) {
            return new ResponseEntity<>(e.getMessage(), CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarProduto(@PathVariable String id, @RequestBody ProdutoDTO produtoDTO) {
        try {
            return ResponseEntity.ok(toDTO(produtoPortaAplicacao.editarProduto(produtoDTO.toDomain(id))));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerProduto(@PathVariable String id) {
        try {
            produtoPortaAplicacao.removerProduto(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<Object> buscarProdutosPorCategoria(@PathVariable Categoria categoria) {
        try {
            return ResponseEntity.ok(produtoPortaAplicacao.buscarProdutosPorCategoria(categoria));
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }
}
