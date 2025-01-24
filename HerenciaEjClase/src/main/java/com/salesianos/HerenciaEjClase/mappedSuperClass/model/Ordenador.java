package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Ordenador extends Electronica{

    private String procesador;
    private String ram;
    private String grafica;

    public Ordenador(double precio, String procesador, String ram, String grafica) {
        super(precio);
        this.procesador = procesador;
        this.ram = ram;
        this.grafica = grafica;
    }

}
