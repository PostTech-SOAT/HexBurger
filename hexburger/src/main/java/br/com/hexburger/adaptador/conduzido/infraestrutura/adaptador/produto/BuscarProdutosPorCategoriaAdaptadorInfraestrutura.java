package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.produto;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ProdutoRepository;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.BuscarProdutosPorCategoriaPortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarProdutosPorCategoriaAdaptadorInfraestrutura implements BuscarProdutosPorCategoriaPortaInfraestrutura {

    private final ProdutoRepository repository;

    @Override
    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria).stream().map(EProduto::toDomain).toList();
    }

}
