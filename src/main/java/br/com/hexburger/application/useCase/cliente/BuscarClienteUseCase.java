package br.com.hexburger.application.useCase.cliente;

import br.com.hexburger.application.gateway.ClienteGateway;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;

public class BuscarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente buscarCliente(String cpf) {
        return clienteGateway.buscarCliente(cpf).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
}
