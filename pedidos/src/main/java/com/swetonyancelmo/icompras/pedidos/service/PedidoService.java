package com.swetonyancelmo.icompras.pedidos.service;

import com.swetonyancelmo.icompras.pedidos.model.Pedido;
import com.swetonyancelmo.icompras.pedidos.repository.ItemPedidoRepository;
import com.swetonyancelmo.icompras.pedidos.repository.PedidoRepository;
import com.swetonyancelmo.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;

    public Pedido criarPedido(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }

}
