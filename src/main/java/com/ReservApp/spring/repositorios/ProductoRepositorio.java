package com.ReservApp.spring.repositorios;

import com.ReservApp.spring.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
    
}
