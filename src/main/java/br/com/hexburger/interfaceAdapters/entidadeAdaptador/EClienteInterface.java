package br.com.hexburger.interfaceAdapters.entidadeAdaptador;

import br.com.hexburger.dominio.entidade.Cliente;

public interface EClienteInterface {

    String getCpf();

    String getNome();

    String getEmail();

    static EClienteInterface toEntity(Cliente cliente) {
        return null; //todo: implement this method
    }

    Cliente toDomain();
}
