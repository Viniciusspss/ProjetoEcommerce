package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
    
}
