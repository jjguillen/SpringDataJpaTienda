package com.jaroso.springjpa.entities;

import jakarta.persistence.*;
import com.jaroso.springjpa.entities.Pedido;

@Entity
public class LineaPedido {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    private Long id;

    private int cantidad;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_producto"))
    private Producto producto;




}
