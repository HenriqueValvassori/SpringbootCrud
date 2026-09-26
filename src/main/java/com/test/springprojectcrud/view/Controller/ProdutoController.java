package com.test.springprojectcrud.view.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springprojectcrud.Model.Produto;
import com.test.springprojectcrud.Services.ProdutoServices;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoServices produtoServices;

    // Injeção via construtor
    public ProdutoController(ProdutoServices produtoServices) {
        this.produtoServices = produtoServices;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos() {
        return ResponseEntity.ok(produtoServices.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterPorId(@PathVariable Integer id) {
        return produtoServices.obterPorId(id)
                .map(produto -> ResponseEntity.ok(produto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        Produto novoProduto = produtoServices.adicionar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        produtoServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        return ResponseEntity.ok(produtoServices.atualizar(id, produto));
    }
}