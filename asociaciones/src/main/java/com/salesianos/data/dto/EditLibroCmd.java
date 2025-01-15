package com.salesianos.data.dto;

public record EditLibroCmd(
        String nombre,
        String descripcion,
        double precio,
        Long autorId
) {

}
