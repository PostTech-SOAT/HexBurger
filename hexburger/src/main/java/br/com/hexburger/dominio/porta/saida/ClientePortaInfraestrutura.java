package br.com.hexburger.dominio.porta.saida;

import br.com.hexburger.dominio.entidade.Cliente;

import java.util.Optional;

public interface ClientePortaInfraestrutura {

    Cliente criarCliente(Cliente cliente);
    Optional<Cliente> buscarCliente(String cpf);

}
