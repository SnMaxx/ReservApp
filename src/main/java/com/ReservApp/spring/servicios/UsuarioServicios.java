/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReservApp.spring.servicios;

import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author snmax
 */
@Service
public class UsuarioServicios {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional(rollbackFor = Throwable.class)
    public Usuario save(String nombre, String apellido, Integer numeroTel, String email, String password) throws Exception{
        validator(nombre,apellido,numeroTel,email,password);
        Usuario entidad = new Usuario(nombre,apellido,numeroTel,email,password);
        return usuarioRepositorio.save(entidad);
    }
    
    
    
    public void validator(String nombre, String apellido, Integer numeroTel, String email, String password) throws Exception{
        
        
        
        if(nombre==null || nombre.trim().isEmpty())
            throw new Exception("Nombre Invalido");
        
        if(apellido==null || apellido.trim().isEmpty())
            throw new Exception("Apellido Invalido");
        
        if(numeroTel==null || numeroTel>0)
            throw new Exception("Numero invalido");
        
        if(email==null || email.trim().isEmpty())
            throw new Exception("Email Invalido");
        Usuario u = usuarioRepositorio.findByEmail(email);
        if(u!=null)
            throw new Exception("Ya posees una cuenta registrada!");
        
        if(password==null || password.trim().isEmpty())
            throw new Exception("Contraseña Invalida");
    }
    
    
    
}
