package com.salesianos.HerenciaEjClase.singleTable.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Socio {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
    private double cuota;

    public Socio(String nombre, String apellidos, String email, String telefono, String dni, LocalDate fechaNacimiento, LocalDate fechaAlta, double cuota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.cuota = cuota;
    }

}
