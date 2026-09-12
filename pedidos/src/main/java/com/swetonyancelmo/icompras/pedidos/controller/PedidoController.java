package com.swetonyancelmo.icompras.pedidos.controller;

import com.swetonyancelmo.icompras.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import com.swetonyancelmo.icompras.pedidos.controller.dto.NovoPedidoDTO;
import com.swetonyancelmo.icompras.pedidos.controller.mapper.PedidoMapper;
import com.swetonyancelmo.icompras.pedidos.model.ErroResposta;
import com.swetonyancelmo.icompras.pedidos.model.exception.ItemNaoEncontradoException;
import com.swetonyancelmo.icompras.pedidos.model.exception.ValidationException;
import com.swetonyancelmo.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        try {
            var pedido = mapper.map(dto);
            var novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        } catch (ValidationException e) {
            var erro = new ErroResposta("Erro validação", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO dto) {
        try {
            service.adicionarNovoPagamento(dto.codigoPedido(), dto.dadosCartao(), dto.tipoPagamento());
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            var erro = new ErroResposta("Item não encontrado", "codigoPedido", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

}
