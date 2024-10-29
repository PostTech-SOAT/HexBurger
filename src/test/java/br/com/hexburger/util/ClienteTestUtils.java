package br.com.hexburger.util;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.framework.entidade.ECliente;

public class ClienteTestUtils {

    public static Cliente criarCliente() {

        return new Cliente("12345678900", "Tommy", "tommy@email.com");

    }

    public static ECliente criarECliente() {

        return new ECliente("123456789", "Tommy", "tommy@email.com");

    }

}
