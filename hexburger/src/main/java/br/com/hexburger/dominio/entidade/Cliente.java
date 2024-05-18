package br.com.hexburger.dominio.entidade;

import static org.springframework.util.ObjectUtils.isEmpty;

public class Cliente {

    private final String cpf;

    private final String nome;

    private final String email;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        validaCliente();
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

    private void validaCliente() {
        if (!validaCpf() || !validaNome() || !validaEmail()) {
            throw new IllegalArgumentException("Cliente inválido");
        }
    }

    private boolean validaCpf() {
        return !isEmpty(cpf) && cpf.length() == 11;
    }

    private boolean validaNome() {
        return !isEmpty(nome);
    }

    private boolean validaEmail() {
        return !isEmpty(email);
    }

}
