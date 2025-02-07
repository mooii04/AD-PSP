package com.salesianos.triana.security_clase_prueba.repository;

import com.salesianos.triana.security_clase_prueba.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
