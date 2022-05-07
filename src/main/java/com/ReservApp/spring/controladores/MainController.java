package com.ReservApp.spring.controladores;

import com.ReservApp.spring.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
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
    public String guardar(/*ModelMap modelo, */@RequestParam String nombre, @RequestParam String email, @RequestParam String password) throws Exception{
        try {
            userServ.save(nombre, email, password);
            //modelo.put("exito", "Registro exitoso");
            return "index";
        } catch(Exception e){
            //modelo.put("error", "Falló al registrar");
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
