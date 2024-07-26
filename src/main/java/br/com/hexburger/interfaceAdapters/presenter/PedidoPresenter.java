package br.com.hexburger.interfaceAdapters.presenter;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.interfaceAdapters.dto.ClienteDTO;
import br.com.hexburger.interfaceAdapters.dto.ComboDTO;
import br.com.hexburger.interfaceAdapters.dto.PedidoDTO;
import br.com.hexburger.interfaceAdapters.dto.ProdutoPedidoDTO;

import java.util.List;

public class PedidoPresenter {

    public static PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(pedido.getId(), pedido.getCodigo(), getCombosDTO(pedido), pedido.getValorTotal(), getClienteDTO(pedido), pedido.getStatus(), pedido.getDataPedido());
    }

    private static ClienteDTO getClienteDTO(Pedido pedido) {
        return new ClienteDTO(pedido.getCliente().getCpf(), pedido.getCliente().getNome(), pedido.getCliente().getEmail());
    }

    private static List<ComboDTO> getCombosDTO(Pedido pedido) {
        return pedido.getCombos().stream().map(combo -> new ComboDTO(combo.getId(), combo.getProdutos().stream().map(p ->
                new ProdutoPedidoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getValor(), p.getCategoria())).toList(),
                combo.getValorTotal())).toList();
    }

}
