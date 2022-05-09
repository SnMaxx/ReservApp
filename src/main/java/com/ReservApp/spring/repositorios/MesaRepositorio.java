package com.ReservApp.spring.repositorios;

import com.ReservApp.spring.entidades.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MesaRepositorio extends JpaRepository<Mesa, Integer>{
    
    
}
