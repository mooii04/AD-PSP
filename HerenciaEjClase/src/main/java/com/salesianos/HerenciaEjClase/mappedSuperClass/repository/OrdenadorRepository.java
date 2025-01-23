package com.salesianos.HerenciaEjClase.mappedSuperClass.repository;

import com.salesianos.HerenciaEjClase.mappedSuperClass.model.Ordenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenadorRepository extends JpaRepository<Ordenador, Long> {
}
