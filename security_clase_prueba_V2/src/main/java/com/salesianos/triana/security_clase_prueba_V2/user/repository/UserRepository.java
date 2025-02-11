package com.salesianos.triana.security_clase_prueba_V2.user.repository;

import com.salesianos.triana.security_clase_prueba_V2.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findFirstByUsername(String username);

}
