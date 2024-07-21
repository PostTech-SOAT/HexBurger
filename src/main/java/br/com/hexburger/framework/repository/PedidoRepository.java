package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.EPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<EPedido, String> {
}
