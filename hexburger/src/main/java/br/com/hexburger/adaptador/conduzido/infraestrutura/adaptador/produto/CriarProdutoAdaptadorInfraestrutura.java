package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.produto;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ProdutoRepository;
import br.com.hexburger.dominio.entidade.Produto;
import br.com.hexburger.dominio.porta.saida.produto.CriarProdutoPortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EProduto.toEntity;

@Component
@RequiredArgsConstructor
public class CriarProdutoAdaptadorInfraestrutura implements CriarProdutoPortaInfraestrutura {

    private final ProdutoRepository repository;

    @Override
    public Produto criarProduto(Produto produto) {
        try {
            return repository.save(toEntity(produto)).toDomain();
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Produto já cadastrado");
        }
    }

}
