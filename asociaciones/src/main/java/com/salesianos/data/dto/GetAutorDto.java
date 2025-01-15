package com.salesianos.data.dto;

import com.salesianos.data.model.Autor;

public record GetAutorDto(
        Long id,
        String nombre
) {

    public static GetAutorDto fromAutor(Autor a) {
        return new GetAutorDto(
                a.getId(),
                a.getNombre()
        );
    }

}
