package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.cliente;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.entrada.cliente.BuscarClientePortaAplicacao;
import br.com.hexburger.dominio.useCase.cliente.BuscarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarClienteAdaptadorAplicacao implements BuscarClientePortaAplicacao {

    private final BuscarClienteUseCase useCase;

    @Override
    public Cliente buscarCliente(String cpf) {
        return useCase.buscarCliente(cpf);
    }

}
