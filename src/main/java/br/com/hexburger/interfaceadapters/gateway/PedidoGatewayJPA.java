package br.com.hexburger.interfaceadapters.gateway;

import br.com.hexburger.application.interfacegateway.PedidoGateway;
import br.com.hexburger.dominio.entidade.*;
import br.com.hexburger.interfaceadapters.entidadeadaptador.EPedidoInterface;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.ClienteRepositoryDTO;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.ComboRepositoryDTO;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.PedidoRepositoryDTO;
import br.com.hexburger.interfaceadapters.gateway.repositoryDTO.ProdutoPedidoRepositoryDTO;
import br.com.hexburger.interfaceadapters.repositorioadaptador.PedidoRepositorioAdaptador;

import java.util.List;
import java.util.Optional;

public class PedidoGatewayJPA implements PedidoGateway {

    private final PedidoRepositorioAdaptador repository;

    public PedidoGatewayJPA(PedidoRepositorioAdaptador repository) {
        this.repository = repository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return entityToDomain(repository.criarPedido(domainToRepositoryDto(pedido)));
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return repository.buscarPedidos().stream().map(this::entityToDomain).toList();
    }

    @Override
    public Optional<String> buscarStatusPagamentoPedido(String id) {
        return repository.buscarStatusPagamentoPedido(id);
    }

    @Override
    public void atualizarStatusPagamento(String idPedido, String idExternoPagamento, StatusPagamento statusPagamento) {
        repository.atualizarStatusPagamento(idPedido, idExternoPagamento, statusPagamento.name());
    }

    @Override
    public void atualizarStatusPedido(String idPedido, StatusPedido statusPedido) {
        repository.atualizarStatusPedido(idPedido, statusPedido.name());
    }

    private PedidoRepositoryDTO domainToRepositoryDto(Pedido pedido) {
        List<ComboRepositoryDTO> combosDTO = pedido.getCombos().stream().map(combo -> new ComboRepositoryDTO(combo.getId(), combo.getProdutos().stream().map(p ->
                new ProdutoPedidoRepositoryDTO(p.getId(), p.getNome(), p.getDescricao(), p.getValor(), p.getCategoria())).toList(),
                combo.getValorTotal())).toList();
        ClienteRepositoryDTO clienteDTO = new ClienteRepositoryDTO(pedido.getCliente().getCpf(), pedido.getCliente().getNome(), pedido.getCliente().getEmail());
        return new PedidoRepositoryDTO(pedido.getId(), combosDTO, pedido.getValorTotal(), clienteDTO, pedido.getStatus(), pedido.getStatusPagamento(), pedido.getDataPedido(),
                pedido.getQrCode(), pedido.getIdExternoPagamento());
    }

    private Pedido entityToDomain(EPedidoInterface ePedidoInterface) {
        Cliente cliente = new Cliente(ePedidoInterface.getCliente().getCpf(), ePedidoInterface.getCliente().getNome(), ePedidoInterface.getCliente().getEmail());
        List<Combo> combos = ePedidoInterface.getCombos().stream().map(combo -> new Combo(combo.getId(), combo.getProdutosPedido().stream().map(p ->
                new ProdutoPedido(p.getId(), p.getNome(), p.getDescricao(), p.getValor(), Categoria.valueOf(p.getCategoria()))).toList(),
                combo.getValorTotal())).toList();
        return new Pedido(ePedidoInterface.getId(), ePedidoInterface.getCodigo(), combos, ePedidoInterface.getValorTotal(), cliente,
                StatusPedido.valueOf(ePedidoInterface.getStatus()), StatusPagamento.valueOf(ePedidoInterface.getStatusPagamento()),
                ePedidoInterface.getDataPedido(), ePedidoInterface.getQrCode(), ePedidoInterface.getIdExternoPagamento());
    }

}
