package com.jaroso.springjpa.repositories;

import com.jaroso.springjpa.entities.Proveedor;
import com.jaroso.springjpa.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
