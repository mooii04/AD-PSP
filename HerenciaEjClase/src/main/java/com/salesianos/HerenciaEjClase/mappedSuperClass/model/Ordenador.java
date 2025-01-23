package com.salesianos.HerenciaEjClase.mappedSuperClass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
