package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Produto;
import com.exceptions.EntidadeNaoEncontradaException;
import com.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto encontrarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado com o id: "+id));
    }

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> create(Produto produto) {

        produtoRepository.save(produto);
        return listar();
    }

    public List<Produto> listar () {

        return produtoRepository.findAll();
    }

    public List<Produto> update(Produto produto) {
        produtoRepository.save(produto);
        return listar();
    }
  
    public List<Produto> deletar(Long id) {
        produtoRepository.deleteById(id);
        return listar();
    }
    
    }
    

    

