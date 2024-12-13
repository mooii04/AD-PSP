package com.example.alumnoyproducto.producto;

import java.util.List;

public record ProductoDto (
        String nombre,
        double pvp,
        String imagenes,
        String categoria
){

    public static ProductoDto toProducto(Producto p){
        return new ProductoDto(
                p.getNombre(),
                p.getPvp(),
                p.getImagenes().get(0),
                p.getCategoria().getNombre()
        );
    }

}
