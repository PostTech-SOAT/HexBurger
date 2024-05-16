package br.com.hexburger.adaptador.conduzido.infraestrutura.adaptador;

import br.com.hexburger.adaptador.conduzido.infraestrutura.repository.ClienteRepository;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.dominio.porta.saida.cliente.CriarClientePortaInfraestrutura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente.toDomain;
import static br.com.hexburger.adaptador.conduzido.infraestrutura.entidade.ECliente.toEntity;

@Component
@RequiredArgsConstructor
public class CriarClienteAdaptadorInfraestrutura implements CriarClientePortaInfraestrutura {

    private final ClienteRepository repository;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return toDomain(repository.save(toEntity(cliente)));
    }
}
