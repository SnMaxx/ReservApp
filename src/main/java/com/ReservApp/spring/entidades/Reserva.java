
package com.ReservApp.spring.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Usuario cliente;
    private Enum turno;
    private Integer integrantesMesa;
    @OneToMany
    private List<Producto> comida;
    private Integer precio;

    public Reserva() {
    }

    public Reserva(Usuario cliente, Enum turno, Integer integrantesMesa, List<Producto> comida, Integer precio) {
        this.cliente = cliente;
        this.turno = turno;
        this.integrantesMesa = integrantesMesa;
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

    public void setTurno(Enum turno) {
        this.turno = turno;
    }

    public Integer getIntegrantesMesa() {
        return integrantesMesa;
    }

    public void setIntegrantesMesa(Integer integrantesMesa) {
        this.integrantesMesa = integrantesMesa;
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
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", turno=" + turno + ", integrantesMesa=" + integrantesMesa + ", comida=" + comida + ", precio=" + precio + '}';
    }
    
    
}
