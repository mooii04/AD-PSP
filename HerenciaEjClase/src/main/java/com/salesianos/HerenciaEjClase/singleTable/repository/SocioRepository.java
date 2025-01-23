package com.salesianos.HerenciaEjClase.singleTable.repository;

import com.salesianos.HerenciaEjClase.singleTable.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
