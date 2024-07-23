package br.com.hexburger.interfaceAdapters.repositorioAdaptador;

import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EProdutoInterface;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepositorioAdaptador {

    EProdutoInterface criarProduto(String id, String nome, String descricao, BigDecimal valor, String categoria);
    
    Optional<EProdutoInterface> buscarProdutoPorNome(String nome);
    
    Optional<EProdutoInterface> buscarProdutoPorId(String id);
    
    List<EProdutoInterface> buscarProdutosPorCategoria(String categoria);

    EProdutoInterface editarProduto(String id, String nome, String descricao, BigDecimal valor, String categoria);
    
    void removerProduto(String id);
    
}
