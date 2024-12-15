package com.example.alumnoyproducto.producto;

import java.util.List;

public record ProductoDto (
        String nombre,
        double pvp,
        String imagenes,
        String categoria
){

    //Este metodo convierte un objeto de tipo Producto en un objeto de tipo ProductoDto
    public static ProductoDto toProducto(Producto producto){
        return new ProductoDto(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().get(0),
                producto.getCategoria().getNombre()
        );
    }

}
