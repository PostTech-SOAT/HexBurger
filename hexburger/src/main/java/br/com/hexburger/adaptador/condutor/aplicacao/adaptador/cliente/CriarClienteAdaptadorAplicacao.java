package br.com.hexburger.adaptador.condutor.aplicacao.adaptador.cliente;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.entrada.cliente.CriarClientePortaAplicacao;
import br.com.hexburger.dominio.useCase.cliente.CriarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarClienteAdaptadorAplicacao implements CriarClientePortaAplicacao {

    private final CriarClienteUseCase useCase;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return useCase.criarCliente(cliente);
    }

}
