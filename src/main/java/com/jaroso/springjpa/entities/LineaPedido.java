package com.jaroso.springjpa.entities;

import jakarta.persistence.*;

@Entity
public class LineaPedido {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    private int cantidad;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_producto"))
    private Producto producto;

    public LineaPedido() {
    }

    public LineaPedido(Long id, int cantidad, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LineaPedido{");
        sb.append("id=").append(id);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", producto=").append(producto);
        sb.append('}');
        return sb.toString();
    }
}
