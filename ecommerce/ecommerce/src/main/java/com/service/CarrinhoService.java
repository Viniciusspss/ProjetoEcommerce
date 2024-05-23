package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Carrinho;
import com.exceptions.EntidadeNaoEncontradaException;
import com.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;
   
    public Carrinho encontrarPorId(Long id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Carrinho não encontrado com o id: "+id));
    }

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<Carrinho> create(Carrinho carrinho) {

        carrinhoRepository.save(carrinho);
        return listar();
    }
    public List<Carrinho> listar () {

        return carrinhoRepository.findAll();
    }
    public List<Carrinho> update(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
        return listar();
    
    }

  
    public List<Carrinho> deletar(Long id) {
        carrinhoRepository.deleteById(id);
        return listar();
    }
    
}
