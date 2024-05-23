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

import com.entity.User;
import com.exceptions.EntidadeNaoEncontradaException;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    
    @Autowired
    private UserService userService;
    
    @PostMapping  
     List<User> create(@RequestBody User user) {
        return userService.create(user);

}   

   @GetMapping("/{id}")
public ResponseEntity<User> buscarProdutoPorId(@PathVariable("id") Long id) {
try {
    User user = userService.encontrarPorId(id);
    return ResponseEntity.ok(user);
} catch (EntidadeNaoEncontradaException e) {
        throw new EntidadeNaoEncontradaException("Usuário não encontrado com o id: "+id);
}
}

    @PutMapping
     List<User> update(@RequestBody User user) {
        return userService.update(user);
}

    @DeleteMapping("/{id}")
        List<User> deletar(@PathVariable("id") Long id) {
        User user = userService.encontrarPorId(id);
        if (user == null) {
           throw new EntidadeNaoEncontradaException("Usuário não encontrado com o id: "+id);
        }
        return userService.deletar(id);
}

}
