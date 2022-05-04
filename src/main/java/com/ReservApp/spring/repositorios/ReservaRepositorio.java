package com.ReservApp.spring.repositorios;

import com.ReservApp.spring.entidades.Mesa;
import com.ReservApp.spring.entidades.Reserva;
import com.ReservApp.spring.entidades.Turno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer>{
    
  //  @Query("SELECT c FROM Usuario c WHERE c.email = :email")
  //  public Usuario findByEmail(@Param("email") String email);
    
    @Query("SELECT r FROM Reserva r WHERE r.turno = :turno")
    public List<Reserva> mesaDispo(@Param("turno") String turno);
    
}
