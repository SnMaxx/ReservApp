package com.ReservApp.spring.servicios;


import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.repositorios.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServicios {
    
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    public List<Producto> traerTodo(){
        return productoRepositorio.findAll();
    }
    
    
}
