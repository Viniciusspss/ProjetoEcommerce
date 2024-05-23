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

import com.entity.Carrinho;
import com.exceptions.EntidadeNaoEncontradaException;
import com.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping  
    List<Carrinho> create(@RequestBody Carrinho carrinho) {
       return carrinhoService.create(carrinho);
   
}  @GetMapping("/{id}")
   public ResponseEntity<Carrinho> buscarProdutoPorId(@PathVariable("id") Long id) {
      try {
         Carrinho carrinho = carrinhoService.encontrarPorId(id);
         return ResponseEntity.ok(carrinho);
      } catch (EntidadeNaoEncontradaException e) {
        throw new EntidadeNaoEncontradaException("Carrinho não encontrado com o id: "+id);
      }
}
   
   @PutMapping
    List<Carrinho> update(@RequestBody Carrinho carrinho) {
       return carrinhoService.update(carrinho);
}
   
   @DeleteMapping("{id}")
    List<Carrinho> deletar(@PathVariable("id") Long id) {
      Carrinho carrinho = carrinhoService.encontrarPorId(id);
      if (carrinho == null) {
         throw new EntidadeNaoEncontradaException("Carrinho não encontrado com o ID: " + id);
      }
       return carrinhoService.deletar(id);
}
    
}
