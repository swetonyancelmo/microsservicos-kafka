package com.swetonyancelmo.icompras.pedidos.repository;

import com.swetonyancelmo.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
