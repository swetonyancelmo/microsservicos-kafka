package com.swetonyancelmo.icompras.clientes.controller;

import com.swetonyancelmo.icompras.clientes.model.Cliente;
import com.swetonyancelmo.icompras.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.salvar(cliente));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> obterDados(@PathVariable("codigo") Long codigo) {
        return service.obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
