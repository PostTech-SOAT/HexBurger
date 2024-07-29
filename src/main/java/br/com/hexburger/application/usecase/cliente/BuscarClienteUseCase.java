package br.com.hexburger.application.usecase.cliente;

import br.com.hexburger.application.interfacegateway.ClienteGateway;
import br.com.hexburger.application.util.exception.ResourceNotFoundException;
import br.com.hexburger.dominio.entidade.Cliente;

public class BuscarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente buscarCliente(String cpf) {
        return clienteGateway.buscarCliente(cpf).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
}
