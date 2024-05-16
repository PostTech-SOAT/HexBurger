package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ClienteRepository;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.EncontrarClientePortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EncontrarClienteAdaptadorInfraestrutura implements EncontrarClientePortaInfraestrutura {

    private final ClienteRepository repository;

    @Override
    public Optional<Cliente> encontrarCliente(String cpf) {
        return repository.findById(cpf).map(ECliente::toDomain);
    }

}
