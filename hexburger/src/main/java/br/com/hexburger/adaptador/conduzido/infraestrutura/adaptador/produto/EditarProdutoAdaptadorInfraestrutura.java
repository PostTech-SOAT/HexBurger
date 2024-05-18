package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.produto;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ProdutoRepository;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.EditarProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto.toEntity;

@Component
@RequiredArgsConstructor
public class EditarProdutoAdaptadorInfraestrutura implements EditarProdutoPortaInfraestrutura {

    private final ProdutoRepository repository;

    @Override
    public Produto editarProduto(Produto produto) {
        repository.findById(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return repository.save(toEntity(produto)).toDomain();
    }

}
