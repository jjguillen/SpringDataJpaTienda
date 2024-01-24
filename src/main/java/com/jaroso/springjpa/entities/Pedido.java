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

    @OneToMany
    @JoinColumn(name = "id_producto")
    private ArrayList<LineaPedido> lineas = new ArrayList<>();


}
