/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReservApp.spring.servicios;


import com.ReservApp.spring.entidades.Producto;
import com.ReservApp.spring.entidades.Reserva;
import com.ReservApp.spring.entidades.Usuario;
import com.ReservApp.spring.enumeracion.Turno;
import com.ReservApp.spring.repositorios.ProductoRepositorio;
import com.ReservApp.spring.repositorios.ReservaRepositorio;
import com.ReservApp.spring.repositorios.UsuarioRepositorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author snmax
 */
@Service
public class ReservaServicios {
    
    @Autowired
    private ReservaRepositorio reservaRepo;
    
    
    @Autowired
    private UsuarioRepositorio userRepo;
    
    private SimpleDateFormat formatD = new SimpleDateFormat("yyyy-MM-dd");
    
    //@Autowired
    //private ProductoRepositorio productoRepo;
    
    //@Autowired
    //private MesaRepositorio mesaRepo;
    
    
    public Reserva save(String userID,Date dia,String turno) throws Exception{
        validator(turno, dia);
        Reserva reserva = new Reserva();
        Integer id = Integer.parseInt(userID);
        
        
        reserva.setCliente(userRepo.getById(id));
        /* //COMIDAS
        List<Producto> productos = new ArrayList();
        productos.add(productoRepo.getById(Integer.parseInt(comidaID)));
        reserva.setComida(productos); */ 
        
        reserva.setDia(dia);
        reserva.setTurno(Turno.valueOf(turno));
        return reservaRepo.save(reserva);
    }
    
    public void validator(String turno, Date dia) throws Exception{
        
        if(!turno.equalsIgnoreCase("cena") && !turno.equalsIgnoreCase("almuerzo"))
            throw new Exception("Turno invalido");
        if(dia.compareTo(formatD.parse(formatD.format(new Date())))<0)
            throw new Exception("Dia invalido");
        System.out.println("Hola");
        List<Reserva> reservas = reservaRepo.findAllByTurnoAndDia(Turno.valueOf(turno), dia);
        System.out.println(reservas.size());
        if(reservas.size() >= 3)
            throw new Exception("No hay más mesas");
        
    }
    
    /*public Integer siguienteMesaId(String turno, String dia){
        List<Reserva> reservas = reservaRepo.siguienteMesa(turno,dia);
        List<Mesa> mesas = mesaRepo.findAll();
        Integer mesaID;
        if (!(reservas.size()<mesas.size())){
            mesaID = reservas.size()+1;
        }else mesaID = 1;
        
       return mesaID;
    }*/
    
    /*public void agregarComida(Integer idComida, Integer cantidad){
        
        
    }*/
    
    //public boolean mesaDispo(Mesa mesa, Turno turno){
    //    return (reservaRepositorio.mesaDispo(mesa, turno).length()<20);
    //}
}
