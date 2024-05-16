package br.com.hexburger.adaptador.condutor.aplicacao.adaptador;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.entrada.cliente.EncontrarClientePortaAplicacao;
import br.com.hexburger.dominio.useCase.EncontrarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EncontrarClienteAdaptadorAplicacao implements EncontrarClientePortaAplicacao {

    private final EncontrarClienteUseCase useCase;

    @Override
    public Cliente encontrarCliente(String cpf) {
        return useCase.encontrarCliente(cpf);
    }

}
