package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Electronica {

    @Id
    @GeneratedValue
    protected Long id;

    protected double precio;

    public Electronica(double precio) {
        this.precio = precio;
    }

}
