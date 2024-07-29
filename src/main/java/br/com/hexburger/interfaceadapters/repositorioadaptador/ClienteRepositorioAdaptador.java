package br.com.hexburger.interfaceadapters.repositorioadaptador;

import br.com.hexburger.interfaceadapters.entidadeadaptador.EClienteInterface;

import java.util.Optional;

public interface ClienteRepositorioAdaptador {

    EClienteInterface criarCliente(String cpf, String nome, String email);
    Optional<? extends EClienteInterface> buscarCliente(String cpf);

}
