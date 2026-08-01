package com.swetonyancelmo.icompras.pedidos.controller.dto;

import com.swetonyancelmo.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados,
        TipoPagamento tipoPagamento
) {
}
