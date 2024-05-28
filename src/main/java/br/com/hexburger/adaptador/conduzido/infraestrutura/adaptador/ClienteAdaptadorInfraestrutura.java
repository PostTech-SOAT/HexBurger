package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador;

import br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente;
import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ClienteRepository;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.ClientePortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente.toEntity;

@Component
@RequiredArgsConstructor
public class ClienteAdaptadorInfraestrutura implements ClientePortaInfraestrutura {

    private final ClienteRepository repository;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return repository.save(toEntity(cliente)).toDomain();
    }

    @Override
    public Optional<Cliente> buscarCliente(String cpf) {
        return repository.findById(cpf).map(ECliente::toDomain);
    }

}
