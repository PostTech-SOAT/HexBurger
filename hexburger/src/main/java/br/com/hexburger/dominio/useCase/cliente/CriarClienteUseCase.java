package br.com.hexburger.dominio.useCase.cliente;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.ClientePortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ConflictException;

public class CriarClienteUseCase {

    private final ClientePortaInfraestrutura clientePortaInfraestrutura;

    public CriarClienteUseCase(ClientePortaInfraestrutura criarClientePortaInfraestrutura) {
        this.clientePortaInfraestrutura = criarClientePortaInfraestrutura;
    }

    public Cliente criarCliente(Cliente cliente) {
        if (clientePortaInfraestrutura.buscarCliente(cliente.getCpf()).isPresent()) {
            throw new ConflictException("Cliente já cadastrado");
        }
        return clientePortaInfraestrutura.criarCliente(cliente);
    }
}
