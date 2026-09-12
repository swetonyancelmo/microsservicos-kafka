package com.swetonyancelmo.icompras.pedidos.client.representation;

import jakarta.persistence.Column;

public record ClienteRepresentation(
        Long codigo,
        String nome,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String email,
        String telefone
) {
}
