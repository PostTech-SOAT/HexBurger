package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.cliente;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ClienteRepository;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.BuscarClientePortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarClienteAdaptadorInfraestrutura implements BuscarClientePortaInfraestrutura {

    private final ClienteRepository repository;

    @Override
    public Optional<Cliente> buscarCliente(String cpf) {
        return repository.findById(cpf).map(ECliente::toDomain);
    }

}
