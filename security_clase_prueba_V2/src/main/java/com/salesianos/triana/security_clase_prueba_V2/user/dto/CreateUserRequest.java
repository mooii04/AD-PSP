package com.salesianos.triana.security_clase_prueba_V2.user.dto;

public record CreateUserRequest (
        String username,
        String password,
        String verifyPassword
){
}
