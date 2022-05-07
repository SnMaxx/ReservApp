package com.ReservApp.spring.controladores;

import com.ReservApp.spring.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private UsuarioServicios userServ;
    
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @PostMapping("/login")
    public String logeo(){
        return "login";
    }
    
    @PostMapping("/register")
    public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam String email, @RequestParam String password, @RequestParam String password2) throws Exception{
        try {
            userServ.crearUsuario(nombre, email, password, password2);
            return "index";
        } catch(Exception e){
            modelo.put("error", "Error al registrar");
            return "login";
        }
    }
    

    
    @GetMapping("/eliminar-comida")
    public String eliminarComida(){
        return "eliminar-comida";
    }
    
    @GetMapping("/form-comidas")
    public String formComidas(){
        return "form-comidas";
    }
    
    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }
    
    @GetMapping("/resto")
    public String resto(){
        return "resto";
    }
}
