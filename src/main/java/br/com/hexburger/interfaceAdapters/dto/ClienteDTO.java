package br.com.hexburger.interfaceAdapters.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public class ClienteDTO {

    @Schema(example = "12345678901", requiredMode = REQUIRED, minLength = 11, maxLength = 11, pattern = "^[0-9]{11}$")
    private String cpf;

    @Schema(example = "João da Silva", requiredMode = REQUIRED)
    private String nome;

    @Schema(example = "joao@email.com", requiredMode = REQUIRED)
    private String email;

    public ClienteDTO(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
