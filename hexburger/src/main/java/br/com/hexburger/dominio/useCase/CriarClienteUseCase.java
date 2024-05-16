package br.com.hexburger.dominio.useCase;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.CriarClientePortaInfraestrutura;

public class CriarClienteUseCase {

    private final CriarClientePortaInfraestrutura criarClientePortaInfraestrutura;

    public CriarClienteUseCase(CriarClientePortaInfraestrutura criarClientePortaInfraestrutura) {
        this.criarClientePortaInfraestrutura = criarClientePortaInfraestrutura;
    }

    public Cliente criarCliente(Cliente cliente) {
        return criarClientePortaInfraestrutura.criarCliente(cliente);
    }
}
