package br.com.hexburger.interfaceAdapters.repositorioAdaptador;

import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EClienteInterface;

import java.util.Optional;

public interface ClienteRepositorioAdaptador {

    EClienteInterface criarCliente(String cpf, String nome, String email);
    Optional<EClienteInterface> buscarCliente(String cpf);

}
