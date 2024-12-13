package com.example.alumnoyproducto.alumno;

public record AlumnoDto (
        String nombre,
        String apellidos,
        String email,
        Curso curso,
        Direccion direccion
){

}
