package br.com.hexburger.dominio.porta.saida.cliente;

import br.com.hexburger.dominio.entidade.Cliente;

import java.util.Optional;

public interface EncontrarClientePortaInfraestrutura {

    Optional<Cliente> encontrarCliente(String cpf);

}
