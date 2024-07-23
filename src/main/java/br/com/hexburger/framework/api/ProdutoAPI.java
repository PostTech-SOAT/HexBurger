package br.com.hexburger.framework.api;

import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.util.exception.ConflictException;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;
import br.com.hexburger.framework.repository.ProdutoRepositorioImpl;
import br.com.hexburger.interfaceAdapters.controller.ProdutoController;
import br.com.hexburger.interfaceAdapters.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@Tag(name = "Produto")
@RequiredArgsConstructor
@RequestMapping(value = "/v1/produto")
public class ProdutoAPI {

    private final ProdutoRepositorioImpl repositorio;

    @PostMapping
    @Operation(summary = "Criar um produto")
    public ResponseEntity<Object> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            ProdutoController controller = new ProdutoController();
            return ResponseEntity.ok(controller.criarProduto(produtoDTO, repositorio));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (ConflictException e) {
            return new ResponseEntity<>(e.getMessage(), CONFLICT);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar um produto")
    public ResponseEntity<Object> editarProduto(@PathVariable String id, @RequestBody ProdutoDTO produtoDTO) {
        try {
            ProdutoController controller = new ProdutoController();
            return ResponseEntity.ok(controller.editarProduto(id, produtoDTO, repositorio));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um produto")
    public ResponseEntity<Object> removerProduto(@PathVariable String id) {
        try {
            ProdutoController controller = new ProdutoController();
            controller.removerProduto(id, repositorio);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    @GetMapping("/{categoria}")
    @Operation(summary = "Buscar produtos por categoria")
    public ResponseEntity<Object> buscarProdutosPorCategoria(@PathVariable Categoria categoria) {
        try {
            ProdutoController controller = new ProdutoController();
            return ResponseEntity.ok(controller.buscarProdutosPorCategoria(categoria, repositorio));
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }
}
