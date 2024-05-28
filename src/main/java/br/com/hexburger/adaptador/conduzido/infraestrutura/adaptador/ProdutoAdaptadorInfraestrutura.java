package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ProdutoRepository;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.ProdutoPortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto.toEntity;

@Component
@RequiredArgsConstructor
public class ProdutoAdaptadorInfraestrutura implements ProdutoPortaInfraestrutura {

    private final ProdutoRepository repository;

    @Override
    public Produto criarProduto(Produto produto) {
        return repository.save(toEntity(produto)).toDomain();
    }

    @Override
    public Optional<Produto> buscarProdutoPorNome(String nome) {
        return repository.findByNome(nome).map(EProduto::toDomain);
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(String id) {
        return repository.findById(id).map(EProduto::toDomain);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria).stream().map(EProduto::toDomain).toList();
    }

    @Override
    public Produto editarProduto(Produto produto) {
        return repository.save(toEntity(produto)).toDomain();
    }

    @Override
    public void removerProduto(String id) {
        repository.deleteById(id);
    }
}
