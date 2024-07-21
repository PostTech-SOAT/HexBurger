package br.com.hexburger.interfaceAdapters.gateway;

import br.com.hexburger.application.gateway.ProdutoGateway;
import br.com.hexburger.dominio.entidade.Categoria;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.framework.entidade.EProduto;
import br.com.hexburger.framework.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

import static br.com.hexburger.framework.entidade.EProduto.toEntity;

public class ProdutoGatewayJPA implements ProdutoGateway {

    private final ProdutoRepository repository;

    public ProdutoGatewayJPA(ProdutoRepository repository) {
        this.repository = repository;
    }

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
