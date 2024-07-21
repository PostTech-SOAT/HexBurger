package br.com.hexburger.interfaceAdapters.presenter;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.interfaceAdapters.dto.ClienteDTO;

public class ClientePresenter {

    public static ClienteDTO toDTO(Cliente cliente) {
        return ClienteDTO.toDTO(cliente); //Precisa implementar o método ou podemos só chamar?
    }
}
