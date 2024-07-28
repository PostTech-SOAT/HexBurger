package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.EPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<EPedido, String> {

    @Query(value = "SELECT * FROM PEDIDO WHERE status != 'FINALIZADO' ORDER BY " +
            "CASE status WHEN 'PRONTO' THEN 1 " +
            "WHEN 'EM_PREPARACAO' THEN 2 " +
            "WHEN 'RECEBIDO' THEN 3 " +
            "ELSE 4 END, data_pedido ASC", nativeQuery = true)
    List<EPedido> findPedidosNaoFinalizados();

    @Query(value = "SELECT p.status_pagamento FROM Pedido p WHERE p.id = :id", nativeQuery = true)
    Optional<String> findStatusPagamentoById(@Param("id") String id);

}
