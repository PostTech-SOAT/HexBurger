package br.com.hexburger.adaptador.conduzido.infraestrutura.repository;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ECliente, String> {
}
