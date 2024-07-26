package br.com.hexburger.framework.repository;

import br.com.hexburger.framework.entidade.ECliente;
import br.com.hexburger.framework.entidade.ECombo;
import br.com.hexburger.framework.entidade.EPedido;
import br.com.hexburger.framework.entidade.EProdutoPedido;
import br.com.hexburger.interfaceAdapters.entidadeAdaptador.EPedidoInterface;
import br.com.hexburger.interfaceAdapters.gateway.repositoryDTO.PedidoRepositoryDTO;
import br.com.hexburger.interfaceAdapters.repositorioAdaptador.PedidoRepositorioAdaptador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
        EPedido ePedido = new EPedido(pedidoRepositoryDTO.getId(), pedidoRepositoryDTO.getCodigo(), eCombos, pedidoRepositoryDTO.getValorTotal(), eCliente, pedidoRepositoryDTO.getStatus().name(), pedidoRepositoryDTO.getDataPedido());
        return repository.save(ePedido);
    }

    @Override
    public List<? extends EPedidoInterface> buscarPedidos() {
        return repository.findAll();
    }

}
