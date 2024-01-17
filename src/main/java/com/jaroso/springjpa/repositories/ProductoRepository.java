package com.jaroso.springjpa.repositories;

import com.jaroso.springjpa.entities.Categoria;
import com.jaroso.springjpa.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAllByCategoriaOrderByNombre(Categoria categoria);
    Optional<Producto> findProductoByNombre(String nombre);

}
