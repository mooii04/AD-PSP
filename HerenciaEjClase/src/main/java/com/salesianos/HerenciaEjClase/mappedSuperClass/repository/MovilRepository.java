package com.salesianos.HerenciaEjClase.mappedSuperClass.repository;

import com.salesianos.HerenciaEjClase.mappedSuperClass.model.Movil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovilRepository extends JpaRepository<Movil, Long> {
}
