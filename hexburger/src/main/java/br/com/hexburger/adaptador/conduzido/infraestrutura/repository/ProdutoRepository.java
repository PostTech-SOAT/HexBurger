package br.com.hexburger.adaptador.conduzido.infraestrutura.repository;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto;
import br.com.hexburger.dominio.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<EProduto, String> {

    List<EProduto> findByCategoria(Categoria categoria);
    Optional<EProduto> findByNome(String nome);

}
