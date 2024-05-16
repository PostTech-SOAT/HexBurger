package br.com.hexburger.adaptador.condutor.aplicacao.dto;

import br.com.hexburger.dominio.entidade.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {

    private String cpf;

    private String nome;

    private String email;

    public Cliente toDominio() {
        return new Cliente(cpf, nome, email);
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }
}
