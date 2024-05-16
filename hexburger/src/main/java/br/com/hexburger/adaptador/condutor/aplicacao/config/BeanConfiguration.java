package br.com.hexburger.adaptador.condutor.aplicacao.config;

import br.com.hexburger.dominio.porta.saida.cliente.CriarClientePortaInfraestrutura;
import br.com.hexburger.dominio.porta.saida.cliente.EncontrarClientePortaInfraestrutura;
import br.com.hexburger.dominio.useCase.CriarClienteUseCase;
import br.com.hexburger.dominio.useCase.EncontrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarClienteUseCase criarClienteUseCase(CriarClientePortaInfraestrutura criarClientePortaInfraestrutura) {
        return new CriarClienteUseCase(criarClientePortaInfraestrutura);
    }

    @Bean
    public EncontrarClienteUseCase encontrarClienteUseCase(EncontrarClientePortaInfraestrutura encontrarClientePortaInfraestrutura) {
        return new EncontrarClienteUseCase(encontrarClientePortaInfraestrutura);
    }

}
