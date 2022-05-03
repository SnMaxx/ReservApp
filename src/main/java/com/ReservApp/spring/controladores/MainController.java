package com.ReservApp.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    
    @GetMapping("/index")
    public String index(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
    
    @GetMapping("/reserva")
    public String reserva(){
        return "reserva.html";
    }
    
    @GetMapping("/eliminar-comida")
    public String eliminarComida(){
        return "eliminar-comida.html";
    }
    
    @GetMapping("/form-comidas")
    public String formComidas(){
        return "form-comidas.html";
    }
    
    @GetMapping("/menu")
    public String menu(){
        return "menu.html";
    }
    
    @GetMapping("/resto")
    public String resto(){
        return "resto.html";
    }
}
