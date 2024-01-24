package com.jaroso.springjpa.repositories;

import com.jaroso.springjpa.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
