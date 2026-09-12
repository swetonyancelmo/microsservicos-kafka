package com.swetonyancelmo.icompras.pedidos.validator;

import com.swetonyancelmo.icompras.pedidos.client.ClientesClient;
import com.swetonyancelmo.icompras.pedidos.client.ProdutosClient;
import com.swetonyancelmo.icompras.pedidos.client.representation.ClienteRepresentation;
import com.swetonyancelmo.icompras.pedidos.client.representation.ProdutoRepresentation;
import com.swetonyancelmo.icompras.pedidos.model.ItemPedido;
import com.swetonyancelmo.icompras.pedidos.model.Pedido;
import com.swetonyancelmo.icompras.pedidos.model.exception.ValidationException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido) {
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);
    }

    private void validarCliente(Long codigoCliente) {
        try {
            var response = clientesClient.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de codigo {} encontrado: {}", cliente.codigo(), cliente.nome());
        } catch (FeignException.NotFound e) {
            var message = String.format("Cliente de código %d não encontrado.", codigoCliente);
            throw new ValidationException("codigoCliente", message);
        }
    }

    private void validarItem(ItemPedido itemPedido) {
        try {
            var response = produtosClient.obterDados(itemPedido.getCodigoProduto());
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de codigo {} encontrado {}", produto.codigo(), produto.nome());
        } catch (FeignException.NotFound e) {
            var message = String.format("Produto de código %d não encontrado.", itemPedido.getCodigoProduto());
            throw new ValidationException("codigoProduto", message);
        }
    }

}
