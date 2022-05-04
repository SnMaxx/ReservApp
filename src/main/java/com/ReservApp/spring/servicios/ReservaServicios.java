/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReservApp.spring.servicios;


import com.ReservApp.spring.entidades.Mesa;
import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.entidades.Reserva;
import com.ReservApp.spring.enumeracion.Turno;
import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.repositorios.ReservaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author snmax
 */
@Service
public class ReservaServicios {
    
    @Autowired
    private ReservaRepositorio reservaRepositorio;
    
    public Reserva save(Usuario cliente, Turno turno, Mesa mesa, List<Producto> comida, Integer precio) throws Exception{
        validator(cliente,turno,mesa,precio);
        return null;
    }
    
    public void validator(Usuario cliente, Turno turno, Mesa mesa, Integer precio) throws Exception{
        if(cliente==null)
            throw new Exception("Cliente invalido");
        if(turno==null)
            throw new Exception("Turno invalido");
        if(mesa==null)
            throw new Exception("No se han seleccionado las mesas");
        //if(mesaDispo(mesa,turno))
        //    throw new Exception("Ya no hay mesas disponibles");
        if(precio<=0)
            throw new Exception("Precio invalido");
    }
    
    //public boolean mesaDispo(Mesa mesa, Turno turno){
    //    return (reservaRepositorio.mesaDispo(mesa, turno).length()<20);
    //}
}
