package br.com.hexburger.interfaceAdapters.repositorioAdaptador;

import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EPedidoInterface;
import br.com.hexburger.interfaceAdapters.gateway.repositoryDTO.PedidoRepositoryDTO;

import java.util.List;

public interface PedidoRepositorioAdaptador {

    EPedidoInterface criarPedido(PedidoRepositoryDTO pedidoRepositoryDTO);

    List<? extends EPedidoInterface> buscarPedidos();

}
