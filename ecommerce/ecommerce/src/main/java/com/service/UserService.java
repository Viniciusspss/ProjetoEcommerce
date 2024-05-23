package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.User;
import com.exceptions.EntidadeNaoEncontradaException;
import com.repository.UserRespository;


@Service
public class UserService {
    
    private UserRespository userRespository;

    public User encontrarPorId(Long id) {
        return userRespository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado com o id: "+id));
    }

   public UserService(UserRespository userRespository) {
    this.userRespository = userRespository;
   }

   public List<User> create(User user) {

    userRespository.save(user);
    return listar();
}

public List<User> listar () {
    return userRespository.findAll();
}

public List<User> update(User user) {
    userRespository.save(user);
    return listar();
}


public List<User> deletar(Long id) {
    userRespository.deleteById(id);
    return listar();
}

}

