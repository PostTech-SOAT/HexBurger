package br.com.hexburger.interfaceadapters.controller;

import br.com.hexburger.application.usecase.cliente.BuscarClienteUseCase;
import br.com.hexburger.application.usecase.cliente.CriarClienteUseCase;
import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.interfaceadapters.dto.ClienteDTO;
import br.com.hexburger.interfaceadapters.gateway.ClienteGatewayJPA;
import br.com.hexburger.interfaceadapters.presenter.ClientePresenter;
import br.com.hexburger.interfaceadapters.repositorioadaptador.ClienteRepositorioAdaptador;

public class ClienteController {

    public ClienteDTO criarCliente(ClienteDTO clienteDTO, ClienteRepositorioAdaptador repositorio) {
        CriarClienteUseCase useCase = new CriarClienteUseCase(new ClienteGatewayJPA(repositorio));
        return ClientePresenter.toDTO(useCase.criarCliente(new Cliente(clienteDTO.getCpf(),
                clienteDTO.getNome(), clienteDTO.getEmail())));
    }

    public ClienteDTO buscarCliente(String cpf, ClienteRepositorioAdaptador repositorio) {
        BuscarClienteUseCase useCase = new BuscarClienteUseCase(new ClienteGatewayJPA(repositorio));
        return ClientePresenter.toDTO(useCase.buscarCliente(cpf));
    }
}
