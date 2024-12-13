package com.example.alumnoyproducto.producto;

import java.util.List;

public record ProductoDto (
        String nombre,
        double pvp,
        List<String> imagenes,
        Categoria categoria
){
}
