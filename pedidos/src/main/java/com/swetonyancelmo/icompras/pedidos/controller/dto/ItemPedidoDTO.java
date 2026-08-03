package com.swetonyancelmo.icompras.pedidos.controller.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        Long codigoProduto,
        Long codigoPedido,
        Integer quantidade,
        BigDecimal valorUnitario
) {
}
