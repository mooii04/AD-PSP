package com.salesianos.apart1ej2.util;

import com.salesianos.apart1ej2.model.Categoria;
import com.salesianos.apart1ej2.model.Producto;
import com.salesianos.apart1ej2.repository.CategoriaRepository;
import com.salesianos.apart1ej2.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void run() {

        // Crear categorías
        Categoria c1 = Categoria.builder()
                .nombre("Ropa")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Moda")
                .categoriaPadre(c1)
                .build();

        Categoria c3 = Categoria.builder()
                .nombre("Camisetas")
                .categoriaPadre(c2)
                .build();

        categoriaRepository.save(c1);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);

        // Crear y guardar el producto
        Producto p = Producto.builder()
                .nombre("Camiseta de manga corta")
                .descripcion("Camiseta de manga corta de algodón")
                .pvp(15.0)
                .categoria(c1)
                .build();

        productoRepository.save(p);

        System.out.println("Producto guardado: " + p);
        System.out.println("Categoría guardada: " + c1);
        System.out.println("Categoría guardada: " + c2);
        System.out.println("Categoría guardada: " + c3);

    }

}
