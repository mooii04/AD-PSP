package com.example.alumnoyproducto.dto;

import com.example.alumnoyproducto.model.Categoria;

import java.util.List;

public record ProductoDto (
        String nombre,
        double pvp,
        List<String> imagenes,
        Categoria categoria
){
}
