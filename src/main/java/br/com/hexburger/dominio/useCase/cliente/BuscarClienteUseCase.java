package br.com.hexburger.dominio.useCase.cliente;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.ClientePortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;

public class BuscarClienteUseCase {

    private final ClientePortaInfraestrutura clientePortaInfraestrutura;

    public BuscarClienteUseCase(ClientePortaInfraestrutura clientePortaInfraestrutura) {
        this.clientePortaInfraestrutura = clientePortaInfraestrutura;
    }

    public Cliente buscarCliente(String cpf) {
        return clientePortaInfraestrutura.buscarCliente(cpf).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
}
