package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Electronica {

    @Id
    @GeneratedValue
    protected Long id;

    protected double precio;

    public Electronica(double precio) {
        this.precio = precio;
    }

}
