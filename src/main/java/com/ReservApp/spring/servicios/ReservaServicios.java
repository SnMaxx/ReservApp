/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReservApp.spring.servicios;


import com.ReservApp.spring.entidades.Mesa;
import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.entidades.Reserva;
import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.enumeracion.Turno;
import com.ReservApp.spring.repositorios.ReservaRepositorio;
import com.ReservApp.spring.repositorios.UsuarioRepositorio;
import java.text.SimpleDateFormat;
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
    
    
    @Autowired
    private UsuarioRepositorio userRepo;
    
    
    public Reserva save(Integer userID,String dia,String turno) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //validator(userID, dia, turno);
        Reserva reserva = new Reserva();
        reserva.setCliente(userRepo.getById(userID));
        //reserva.setComida(comida);
        reserva.setDia(format.parse(dia));
        //System.out.println(Turno.valueOf(turno));
        reserva.setTurno(Turno.valueOf(turno));
        
        //reserva.setMesa(siguienteMesa());
        return reservaRepositorio.save(reserva);
    }
    
    public void validator(Integer userID,String dia,String turno) throws Exception{
        if(userRepo.getById(userID)==null)
            throw new Exception("Cliente invalido");
        if(dia==null)
            throw new Exception("Turno invalido");
        //if(siguienteMesa())
        //    throw new Exception("Ya no hay mesas disponibles");
        if(turno.equals("hour-select"))
            throw new Exception("Turno invalido");
    }
    
    /*public Mesa siguienteMesa(){
            return reservaRepositorio.siguienteMesa();
    }*/
    
    /*public void agregarComida(Integer idComida, Integer cantidad){
        
        
    }*/
    
    //public boolean mesaDispo(Mesa mesa, Turno turno){
    //    return (reservaRepositorio.mesaDispo(mesa, turno).length()<20);
    //}
}
