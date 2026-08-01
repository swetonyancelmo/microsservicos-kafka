package com.swetonyancelmo.icompras.pedidos.controller.mapper;

import com.swetonyancelmo.icompras.pedidos.controller.dto.ItemPedidoDTO;
import com.swetonyancelmo.icompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido map(ItemPedidoDTO dto);
}
