package br.com.hexburger.adaptador.condutor.aplicacao.dto;

import br.com.hexburger.dominio.entidade.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@AllArgsConstructor
public class ClienteDTO {

    @Schema(example = "12345678901", requiredMode = REQUIRED, minLength = 11, maxLength = 11, pattern = "^[0-9]{11}$")
    private String cpf;

    @Schema(example = "João da Silva", requiredMode = REQUIRED)
    private String nome;

    @Schema(example = "joao@email.com", requiredMode = REQUIRED)
    private String email;

    public Cliente toDomain() {
        return new Cliente(cpf, nome, email);
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }
}
