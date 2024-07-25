package br.com.hexburger.application.useCase.cliente;

import br.com.hexburger.application.gateway.ClienteGateway;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.interfaceAdapters.util.exception.ConflictException;

public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCase(ClienteGateway criarClienteGateway) {
        this.clienteGateway = criarClienteGateway;
    }

    public Cliente criarCliente(Cliente cliente) {
        if (clienteGateway.buscarCliente(cliente.getCpf()).isPresent()) {
            throw new ConflictException("Cliente já cadastrado");
        }
        return clienteGateway.criarCliente(cliente);
    }
}
