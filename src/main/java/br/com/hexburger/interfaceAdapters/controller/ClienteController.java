package br.com.hexburger.interfaceAdapters.controller;

import br.com.hexburger.application.useCase.cliente.BuscarClienteUseCase;
import br.com.hexburger.application.useCase.cliente.CriarClienteUseCase;
import br.com.hexburger.interfaceAdapters.dto.ClienteDTO;
import br.com.hexburger.interfaceAdapters.presenter.ClientePresenter;

public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        return ClientePresenter.toDTO(criarClienteUseCase.criarCliente(clienteDTO.toDomain()));
    }

    public ClienteDTO buscarCliente(String cpf) {
        return ClientePresenter.toDTO(buscarClienteUseCase.buscarCliente(cpf));
    }
}
