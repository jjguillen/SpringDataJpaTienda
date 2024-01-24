package com.jaroso.springjpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column
    private double precio;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToMany()
    @JoinTable(name = "producto_proveedores")
    private List<Proveedor> proveedores = new ArrayList<>();


    public Producto() {
    }

    public Producto(Long id, String nombre, Categoria categoria, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Producto{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", categoria=").append(categoria);
        sb.append('}');
        return sb.toString();
    }

    public void addProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
        proveedor.getProductos().add(this);
    }
}
