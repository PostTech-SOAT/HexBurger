package br.com.hexburger.dominio.porta.entrada.cliente;

import br.com.hexburger.dominio.entidade.Cliente;

public interface EncontrarClientePortaAplicacao {

    Cliente encontrarCliente(String cpf);

}
