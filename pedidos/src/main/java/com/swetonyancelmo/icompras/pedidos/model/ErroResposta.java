package com.swetonyancelmo.icompras.pedidos.model;

public record ErroResposta(
        String mensagem,
        String campo,
        String erro
) {
}
