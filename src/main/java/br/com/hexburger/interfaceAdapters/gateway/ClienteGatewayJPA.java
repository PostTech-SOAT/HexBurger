package br.com.hexburger.interfaceAdapters.gateway;

import br.com.hexburger.application.gateway.ClienteGateway;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EClienteInterface;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ClienteRepositorioAdaptador;

import java.util.Optional;

public class ClienteGatewayJPA implements ClienteGateway {

    private final ClienteRepositorioAdaptador repository;

    public ClienteGatewayJPA(ClienteRepositorioAdaptador repository) {
        this.repository = repository;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        EClienteInterface eClienteInterface = repository.criarCliente(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
        return new Cliente(eClienteInterface.getCpf(), eClienteInterface.getNome(), eClienteInterface.getEmail());
    }

    @Override
    public Optional<Cliente> buscarCliente(String cpf) {
        return repository.buscarCliente(cpf).map(eClienteInterface -> new Cliente(eClienteInterface.getCpf(), eClienteInterface.getNome(), eClienteInterface.getEmail()));
    }

}
