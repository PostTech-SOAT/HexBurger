package br.com.hexburger.dominio.porta.entrada;

import br.com.hexburger.dominio.entidade.Cliente;

public interface ClientePortaAplicacao {

    Cliente criarCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);

}
