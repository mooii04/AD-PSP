package com.salesianos.apart1ej2.repository;

import com.salesianos.apart1ej2.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
