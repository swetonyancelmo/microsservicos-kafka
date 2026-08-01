package com.swetonyancelmo.icompras.pedidos.repository;

import com.swetonyancelmo.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
