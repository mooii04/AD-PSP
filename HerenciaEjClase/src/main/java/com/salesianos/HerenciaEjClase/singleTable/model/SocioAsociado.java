package com.salesianos.HerenciaEjClase.singleTable.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class SocioAsociado extends Socio {

    private String asiento;
    private String fechaAbono;

    public SocioAsociado(String nombre, String apellidos, String email, String telefono, String dni, LocalDate fechaNacimiento, LocalDate fechaAlta, double cuota, String asiento, String fechaAbono) {
        super(nombre, apellidos, email, telefono, dni, fechaNacimiento, fechaAlta, cuota);
        this.asiento = asiento;
        this.fechaAbono = fechaAbono;
    }

}
