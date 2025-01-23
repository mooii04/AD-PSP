package com.salesianos.HerenciaEjClase.joined.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private LocalDate fechaEvento;
    private String lugar;

    public Evento(String nombre, LocalDate fechaEvento, String lugar) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.lugar = lugar;
    }

}
