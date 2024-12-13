package com.example.alumnoyproducto.dto;

import com.example.alumnoyproducto.model.Curso;
import com.example.alumnoyproducto.model.Direccion;

public record AlumnoDto (
        String nombre,
        String apellidos,
        String email,
        Curso curso,
        Direccion direccion
){

}
