package com.ReservApp.spring.controladores;

import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.servicios.ProductoServicios;
import com.ReservApp.spring.servicios.ReservaServicios;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    public String guardar(/*ModelMap modelo, */@RequestParam String dia, @RequestParam String turno, @RequestParam Integer userID) throws Exception{
        try {
            reservaServ.save(userID, dia, turno);
            //modelo.put("exito", "Registro exitoso");
            return "index";
        } catch(Exception e){
            //modelo.put("error", "Falló al registrar");
            return "reserva";
        }
    }
}
