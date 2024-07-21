package br.com.hexburger.interfaceAdapters.dto;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.framework.entidade.ECliente;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente toDomain() {
        return new Cliente(cpf, nome, email);
    }

    public static ECliente toEntity(Cliente cliente) {
        return new ECliente(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }
}
