package com.salesianos.HerenciaEjClase.mappedSuperClass.repository;

import com.salesianos.HerenciaEjClase.mappedSuperClass.model.Electronica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicaRepository extends JpaRepository<Electronica, Long> {
}
