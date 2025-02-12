package com.salesianos.triana.security_clase_prueba_V2.user.service;

import com.salesianos.triana.security_clase_prueba_V2.user.dto.CreateUserRequest;
import com.salesianos.triana.security_clase_prueba_V2.user.model.User;
import com.salesianos.triana.security_clase_prueba_V2.user.model.UserRole;
import com.salesianos.triana.security_clase_prueba_V2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest createUserRequest) {
        User user =  User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);
    }

}
