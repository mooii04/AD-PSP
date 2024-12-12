package com.example.monumentos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumentos {

    /*
        Su ID (un número entero)
        El código de país (según el código ISO 3166-1 alfa 2).
        El nombre del país.
        El nombre de la ciudad.
        Su localización (latitud, longitud).
        El nombre del monumento
        Un descripción del mismo
        La URL de una foto.
     */

    private Long id;
    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    private String descripcion;
    private String url;

}
