package com.jaroso.springjpa.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Proveedor {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    @ManyToMany(mappedBy = "proveedores")
    private List<Producto> productos = new ArrayList<>();

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Transactional
    public void addProducto(Producto producto) {
        this.productos.add(producto);
        //Hibernate.initialize(producto.getProveedores()); para el LAZY
        producto.getProveedores().add(this);
    }


}
