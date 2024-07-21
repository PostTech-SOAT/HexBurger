package br.com.hexburger.framework.entidade;

import br.com.hexburger.dominio.entidade.Cliente;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EClienteInterface;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class ECliente implements Serializable, EClienteInterface {

    @Id
    private String cpf;

    private String nome;

    private String email;

    public static ECliente toEntity(Cliente cliente) {
        return new ECliente(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }

    public Cliente toDomain() {
        return new Cliente(this.getCpf(), this.getNome(), this.getEmail());
    }

}