package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.ECliente;
import br.com.hexburger.framework.entidade.ECombo;
import br.com.hexburger.framework.entidade.EPedido;
import br.com.hexburger.framework.entidade.EProdutoPedido;
import br.com.hexburger.interfaceadapters.entidadeadaptador.EPedidoInterface;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.PedidoRepositoryDTO;
import br.com.hexburger.interfaceadapters.repositorioadaptador.PedidoRepositorioAdaptador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PedidoRepositorioImpl implements PedidoRepositorioAdaptador {

    private final PedidoRepository repository;

    @Override
    public EPedidoInterface criarPedido(PedidoRepositoryDTO pedidoRepositoryDTO) {
        List<ECombo> eCombos = pedidoRepositoryDTO.getCombos().stream().map(combo -> new ECombo(combo.getId(), combo.getProdutos().stream().map(p ->
                new EProdutoPedido(p.getId(), p.getNome(), p.getDescricao(), p.getValor(), p.getCategoria().name())).toList(),
                combo.getValorTotal())).toList();
        ECliente eCliente = new ECliente(pedidoRepositoryDTO.getCliente().getCpf(), pedidoRepositoryDTO.getCliente().getNome(), pedidoRepositoryDTO.getCliente().getEmail());
        EPedido ePedido = new EPedido(pedidoRepositoryDTO.getId(), eCombos, pedidoRepositoryDTO.getValorTotal(), eCliente, pedidoRepositoryDTO.getStatus().name(),
                pedidoRepositoryDTO.getStatusPagamento().name(), pedidoRepositoryDTO.getDataPedido(), pedidoRepositoryDTO.getQrCode(), pedidoRepositoryDTO.getIdExternoPagamento());
        return repository.save(ePedido);
    }

    @Override
    public List<? extends EPedidoInterface> buscarPedidos() {
        return repository.findPedidosNaoFinalizados();
    }

    @Override
    public Optional<String> buscarStatusPagamentoPedido(String id) {
        return repository.findStatusPagamentoById(id);
    }

    @Override
    @Transactional
    public void atualizarStatusPagamento(String idPedido, String idExternoPagamento, String statusPagamento) {
        repository.updateStatusPagamento(idPedido, idExternoPagamento, statusPagamento);
    }

    @Override
    @Transactional
    public void atualizarStatusPedido(String idPedido, String statusPedido) {
        repository.updateStatusPagamento(idPedido, statusPedido);
    }

}
