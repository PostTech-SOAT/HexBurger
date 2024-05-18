package br.com.hexburger.dominio.useCase.cliente;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.BuscarClientePortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ResourceNotFoundException;

public class BuscarClienteUseCase {

    private final BuscarClientePortaInfraestrutura buscarClientePortaInfraestrutura;

    public BuscarClienteUseCase(BuscarClientePortaInfraestrutura buscarClientePortaInfraestrutura) {
        this.buscarClientePortaInfraestrutura = buscarClientePortaInfraestrutura;
    }

    public Cliente buscarCliente(String cpf) {
        return buscarClientePortaInfraestrutura.buscarCliente(cpf).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
}
