package com.ReservApp.spring.controladores;

import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.servicios.ProductoServicios;
import com.ReservApp.spring.servicios.ReservaServicios;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/reserva")
public class ReservaControlador {
    
    @Autowired
    private ReservaServicios reservaServ; 
    
    @Autowired
    private ProductoServicios productoServ;
    
    @GetMapping("")
    public String reserva(ModelMap modelo, HttpSession session){
        
        List<Producto> productosLista = productoServ.traerTodo();
        modelo.put("usuario",(Usuario) session.getAttribute("usuariosession"));
        
        modelo.addAttribute("comidas", productosLista);
        
        return "reserva";
    }
    
    @PostMapping("")
    public String guardar(@DateTimeFormat(pattern = "yyyy-MM-dd") Date dia, @RequestParam String turno, @RequestParam String id, ModelMap modelo) throws Exception{
        try {
            reservaServ.save(id, dia, turno);
            return "index";
        } catch(Exception e){
            e.printStackTrace();
            modelo.put("ReservError", e.getMessage()); 
            return "redirect:/reserva";
        }
    }
}
