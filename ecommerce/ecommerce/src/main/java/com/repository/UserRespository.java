package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;


public interface UserRespository extends JpaRepository<User,Long>{


    
}
