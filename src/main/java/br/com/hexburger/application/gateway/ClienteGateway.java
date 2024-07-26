package br.com.hexburger.application.gateway;

import br.com.hexburger.dominio.entidade.Cliente;

import java.util.Optional;

public interface ClienteGateway {

    Cliente criarCliente(Cliente cliente);
    Optional<Cliente> buscarCliente(String cpf);

}
