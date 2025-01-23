package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movil extends Electronica {

    private String marca;
    private String modelo;

    public Movil(double precio, String marca, String modelo) {
        super(precio);
        this.marca = marca;
        this.modelo = modelo;
    }

}
