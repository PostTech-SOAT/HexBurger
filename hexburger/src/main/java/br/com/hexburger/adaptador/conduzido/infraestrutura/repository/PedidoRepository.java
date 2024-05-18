package br.com.hexburger.adaptador.conduzido.infraestrutura.repository;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.EPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<EPedido, String> {
}
