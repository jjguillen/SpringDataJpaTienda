package com.jaroso.springjpa.entities;

import jakarta.persistence.*;

@Entity
public class LineaPedido {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_producto"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", foreignKey = @ForeignKey(name = "fk_linea_pedido"))
    private Pedido pedido;


    public LineaPedido() {
    }

    public LineaPedido(Long id, int cantidad, Producto producto, Pedido pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LineaPedido{");
        sb.append("id=").append(id);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", producto=").append(producto);
        sb.append(", pedido=").append(pedido);
        sb.append('}');
        return sb.toString();
    }
}
