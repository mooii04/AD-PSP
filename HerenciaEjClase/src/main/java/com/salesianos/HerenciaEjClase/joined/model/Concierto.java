package com.salesianos.HerenciaEjClase.joined.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Concierto extends Evento {

    private String artista;
    private String generoMusical;

    public Concierto(String nombre, LocalDate fechaEvento, String lugar, String artista, String generoMusical) {
        super(nombre, fechaEvento, lugar);
        this.artista = artista;
        this.generoMusical = generoMusical;
    }
}
