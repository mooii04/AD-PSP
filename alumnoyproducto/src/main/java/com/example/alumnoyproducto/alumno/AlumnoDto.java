package com.example.alumnoyproducto.alumno;

public record AlumnoDto (
        String nombre,
        String apellidos,
        String email,
        String curso,
        String direccion
){

    // Este método convierte un objeto de tipo Alumno en un objeto de tipo AlumnoDto
    public static AlumnoDto toAlumno(Alumno alumno){
        return new AlumnoDto(
                alumno.getNombre(),
                alumno.getApellido1() + " " + alumno.getApellido2(),
                alumno.getEmail(),
                alumno.getCurso().getNombre(),
                alumno.getDireccion().getLinea1()
        );
    }

}
