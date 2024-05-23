package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Produto;
import com.exceptions.EntidadeNaoEncontradaException;
import com.service.ProdutoService;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping  
     List<Produto> create(@RequestBody Produto produto) {
        return produtoService.create(produto);
    
}   @GetMapping("/{id}")
        public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id) {
        try {
            Produto produto = produtoService.encontrarPorId(id);
            return ResponseEntity.ok(produto);
        } catch (EntidadeNaoEncontradaException e) {
                throw new EntidadeNaoEncontradaException("Produto não encontrado com o id: "+id);
        }
    }
    @PutMapping
     List<Produto> update(@RequestBody Produto produto) {
        return produtoService.update(produto);
}
    @DeleteMapping("/{id}")
     List<Produto> deletar(@PathVariable("id") Long id) {
        Produto produto = produtoService.encontrarPorId(id);
        if (produto == null) {
                throw new EntidadeNaoEncontradaException("Produto não encontrado com o id: "+id);
        }
        return produtoService.deletar(id);
}

}
