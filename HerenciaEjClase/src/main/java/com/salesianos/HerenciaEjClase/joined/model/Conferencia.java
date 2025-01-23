package com.salesianos.HerenciaEjClase.joined.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Conferencia extends Evento {

    private String ponente;
    private String tema;

    public Conferencia(String nombre, LocalDate fechaEvento, String lugar, String ponente, String tema) {
        super(nombre, fechaEvento, lugar);
        this.ponente = ponente;
        this.tema = tema;
    }
}
