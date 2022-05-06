package com.ReservApp.spring.controladores;

import com.ReservApp.spring.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
     
    @Autowired
    private UsuarioServicios usuarioServicios;
    
    @GetMapping("/login")
    public String formulario(){
        
        return "login";
        
    }
    
public String Guardar(ModelMap Modelo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam Integer password ) throws Exception{
    
    try {
        usuarioServicios.save(nombre, email, apellido);
        
        Modelo.put("exito","Registro exitoso");
        
        return "login";
    }catch (Exception e) {
        
        Modelo.put("error","Faltan datos");
        return "login";
    }
}
}
