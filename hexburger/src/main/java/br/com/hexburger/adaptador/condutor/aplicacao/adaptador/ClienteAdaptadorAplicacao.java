package br.com.hexburger.adaptador.condutor.aplicacao.adaptador;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.entrada.ClientePortaAplicacao;
import br.com.hexburger.dominio.useCase.cliente.BuscarClienteUseCase;
import br.com.hexburger.dominio.useCase.cliente.CriarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteAdaptadorAplicacao implements ClientePortaAplicacao {

    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return criarClienteUseCase.criarCliente(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return buscarClienteUseCase.buscarCliente(cpf);
    }
}
