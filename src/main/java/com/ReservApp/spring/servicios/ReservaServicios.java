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
import java.util.Date;
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
    
    /*HAY QUE ARREGLAR ESTO (LO COMENTO PARA QUE NOTE TIRE ERROR)
    public Reserva save(Usuario cliente, Turno turno, List<Producto> comida, Integer precio, Date dia) throws Exception{
        validator(cliente,turno,precio);
        Reserva reserva = new Reserva(cliente, turno,siguienteMesa(dia, turno),comida,precio);
        return reservaRepositorio.save(reserva);
    }*/
    
    public void validator(Usuario cliente, Turno turno, Integer precio) throws Exception{
        if(cliente==null)
            throw new Exception("Cliente invalido");
        if(turno==null)
            throw new Exception("Turno invalido");
        //if(mesaDispo(mesa,turno))
        //    throw new Exception("Ya no hay mesas disponibles");
        if(precio<=0)
            throw new Exception("Precio invalido");
    }
    
   /* public Mesa siguienteMesa(){
        try{
            return reservaRepositorio.siguienteMesa();
            
        } catch (Exception e){
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
            return null;
        }
    }
    
    public void agregarComida(Integer idComida, Integer cantidad){
        
        
    }*/
    
    //public boolean mesaDispo(Mesa mesa, Turno turno){
    //    return (reservaRepositorio.mesaDispo(mesa, turno).length()<20);
    //}
}
