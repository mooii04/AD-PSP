package com.salesianos.triana.security_clase_prueba_V2.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianos.triana.security_clase_prueba_V2.user.model.User;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token
) {

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    public static UserResponse of(User user, String token) {
        return new UserResponse(user.getId(), user.getUsername(), token);
    }

}
