package com.salesianos.data.dto;

import com.salesianos.data.model.Libro;

public record GetLibroDto(
        Long id,
        String nombre,
        double precio,
        GetAutorDto autorId
) {

    public static GetLibroDto of(Libro l) {
        return new GetLibroDto(
                l.getId(),
                l.getNombre(),
                l.getPrecio(),
                GetAutorDto.fromAutor(l.getAutor())
        );

    }

}
