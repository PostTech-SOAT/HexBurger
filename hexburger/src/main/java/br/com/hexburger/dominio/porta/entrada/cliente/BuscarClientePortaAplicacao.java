package br.com.hexburger.dominio.porta.entrada.cliente;

import br.com.hexburger.dominio.entidade.Cliente;

public interface BuscarClientePortaAplicacao {

    Cliente buscarCliente(String cpf);

}
