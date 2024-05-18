package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.produto;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ProdutoRepository;
import br.com.hexburger.dominio.porta.saida.produto.RemoverProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoverProdutoAdaptadorInfraestrutura implements RemoverProdutoPortaInfraestrutura {

    private final ProdutoRepository repository;

    @Override
    public void removerProduto(String id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        repository.deleteById(id);
    }

}
