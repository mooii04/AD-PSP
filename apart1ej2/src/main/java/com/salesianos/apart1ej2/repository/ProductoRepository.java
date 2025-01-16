package com.salesianos.apart1ej2.repository;

import com.salesianos.apart1ej2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
