package com.salesianos.HerenciaEjClase.joined.repository;

import com.salesianos.HerenciaEjClase.joined.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
