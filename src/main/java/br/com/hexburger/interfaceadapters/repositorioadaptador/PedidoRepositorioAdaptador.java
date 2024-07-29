package br.com.hexburger.interfaceadapters.repositorioadaptador;

import br.com.hexburger.interfaceadapters.entidadeadaptador.EPedidoInterface;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.PedidoRepositoryDTO;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositorioAdaptador {

    EPedidoInterface criarPedido(PedidoRepositoryDTO pedidoRepositoryDTO);

    List<? extends EPedidoInterface> buscarPedidos();

    Optional<String> buscarStatusPagamentoPedido(String id);

    void atualizarStatusPagamento(String idPedido, String idExternoPagamento, String statusPagamento);

    void atualizarStatusPedido(String idPedido, String statusPedido);

}
