package br.com.hexburger.application.usecase.cliente;

import br.com.hexburger.application.interfacegateway.ClienteGateway;
import br.com.hexburger.application.util.exception.ConflictException;
import br.com.hexburger.dominio.entidade.Cliente;

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
