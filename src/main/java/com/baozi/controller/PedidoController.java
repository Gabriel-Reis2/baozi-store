package com.baozi.controller;

import com.baozi.model.Pedido;
import com.baozi.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar pedido
    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    // Listar todos os pedidos
    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(
            @PathVariable Long id,
            @RequestBody Pedido pedido) {

        return repository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setClienteId(pedido.getClienteId());
                    pedidoExistente.setProdutoId(pedido.getProdutoId());
                    pedidoExistente.setQuantidade(pedido.getQuantidade());

                    return ResponseEntity.ok(repository.save(pedidoExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}