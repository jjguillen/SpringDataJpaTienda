package com.jaroso.springjpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.jaroso.springjpa.entities.LineaPedido;

@Entity
public class Pedido {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    private LocalDate fecha;
    private String direccionEnvio;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Long id, LocalDate fecha, String direccionEnvio) {
        this.id = id;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    /**
     * Métodos para añadir y eliminar lineas de pedido, al pedido
     */
    public void addLinea(LineaPedido lp) {
        this.lineas.add(lp);
        lp.setPedido(this);
    }

    public void removeLinea(LineaPedido lp) {
        this.lineas.remove(lp);
        lp.setPedido(null);
        //Borrar la línea de pedido

    }



}
