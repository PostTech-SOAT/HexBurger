package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.ECliente;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.ClienteRepositorioAdaptador;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EClienteInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepositorioAdaptador {

    private final ClienteRepository repository;

    @Override
    public EClienteInterface criarCliente(EClienteInterface cliente) {
        return repository.save((ECliente) cliente);
    }

    @Override
    public Optional<EClienteInterface> buscarCliente(String cpf) {
        return repository.findById(cpf).map(eCliente -> eCliente);
    }
}
