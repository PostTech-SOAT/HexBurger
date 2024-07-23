package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.EProduto;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EProdutoInterface;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ProdutoRepositorioAdaptador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProdutoRepositorioImpl implements ProdutoRepositorioAdaptador {

    private final ProdutoRepository repository;

    @Override
    public EProdutoInterface criarProduto(String id, String nome, String descricao, BigDecimal valor, String categoria) {
        return repository.save(new EProduto(id, nome, descricao, valor, categoria));
    }

    @Override
    public Optional<EProdutoInterface> buscarProdutoPorNome(String nome) {
        return repository.findByNome(nome).map(eProduto -> eProduto);
    }

    @Override
    public Optional<EProdutoInterface> buscarProdutoPorId(String id) {
        return repository.findById(id).map(eProduto -> eProduto);
    }

    @Override
    public List<EProdutoInterface> buscarProdutosPorCategoria(String categoria) {
        return repository.findByCategoria(categoria).stream().map(EProdutoInterface.class::cast).toList();
    }

    @Override
    public EProdutoInterface editarProduto(String id, String nome, String descricao, BigDecimal valor, String categoria) {
        return repository.save(new EProduto(id, nome, descricao, valor, categoria));
    }

    @Override
    public void removerProduto(String id) {
        repository.deleteById(id);
    }

}
