package com.jaroso.springjpa.repositories;

import com.jaroso.springjpa.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //Ya vienen incluidos: find, findAll, remove, save

    //Métodos nuevos para hacer consultas
    List<Pedido> findPedidoByFechaAfter(LocalDate fecha);

}
