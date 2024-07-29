package br.com.hexburger.interfaceadapters.presenter;

import br.com.hexburger.dominio.entidade.Pedido;
import br.com.hexburger.interfaceadapters.dto.ClienteDTO;
import br.com.hexburger.interfaceadapters.dto.ComboDTO;
import br.com.hexburger.interfaceadapters.dto.PedidoDTO;
import br.com.hexburger.interfaceadapters.dto.ProdutoPedidoDTO;

import java.util.List;

public class PedidoPresenter {

    public static PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(pedido.getId(), pedido.getCodigo(), getCombosDTO(pedido), pedido.getValorTotal(), getClienteDTO(pedido),
                pedido.getStatus(), pedido.getStatusPagamento(), pedido.getDataPedido(), pedido.getQrCode(), pedido.getIdExternoPagamento());
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
