package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Movil extends Electronica {

    private String marca;
    private String modelo;

    public Movil(double precio, String marca, String modelo) {
        super(precio);
        this.marca = marca;
        this.modelo = modelo;
    }

}
