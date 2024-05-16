package br.com.hexburger.dominio.useCase;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.EncontrarClientePortaInfraestrutura;
import org.hibernate.ObjectNotFoundException;

import static java.util.Optional.ofNullable;

public class EncontrarClienteUseCase {

    private final EncontrarClientePortaInfraestrutura encontrarClientePortaInfraestrutura;

    public EncontrarClienteUseCase(EncontrarClientePortaInfraestrutura encontrarClientePortaInfraestrutura) {
        this.encontrarClientePortaInfraestrutura = encontrarClientePortaInfraestrutura;
    }

    //todo - Criar uma exception para o caso de não encontrar o cliente (e handler de erro)
    public Cliente encontrarCliente(String cpf) {
        return encontrarClientePortaInfraestrutura.encontrarCliente(cpf).orElseThrow(() -> new ObjectNotFoundException(ofNullable(cpf), "ECliente"));
    }
}
