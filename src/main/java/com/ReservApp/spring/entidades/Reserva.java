
package com.ReservApp.spring.entidades;

import com.ReservApp.spring.enumeracion.Turno;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Usuario cliente;
    private Turno turno;
    @OneToOne
    private Mesa mesa;
    @OneToMany
    private List<Producto> comida;
    private Integer precio;

    public Reserva() {
    }

    public Reserva(Usuario cliente, Turno turno, Mesa mesa, List<Producto> comida, Integer precio) {
        this.cliente = cliente;
        this.turno = turno;
        this.mesa = mesa;
        this.comida = comida;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Enum getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Producto> getComida() {
        return comida;
    }

    public void setComida(List<Producto> comida) {
        this.comida = comida;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", turno=" + turno + ", mesa=" + mesa + ", comida=" + comida + ", precio=" + precio + '}';
    }

}
