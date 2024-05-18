package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador.cliente;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ClienteRepository;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.CriarClientePortaInfraestrutura;
import br.com.hexburger.dominio.util.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente.toEntity;

@Component
@RequiredArgsConstructor
public class CriarClienteAdaptadorInfraestrutura implements CriarClientePortaInfraestrutura {

    private final ClienteRepository repository;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        repository.findById(cliente.getCpf()).ifPresent(eCliente -> {
            throw new ConflictException("Cliente já cadastrado");
        });
        return repository.save(toEntity(cliente)).toDomain();
    }
}
