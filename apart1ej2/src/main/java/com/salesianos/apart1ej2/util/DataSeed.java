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
        Categoria casual = categoriaRepository.save(
                Categoria.builder().nombre("Casual").build()
        );

        Categoria hombre = categoriaRepository.save(
                Categoria.builder().nombre("Hombre").categorias(
                        List.of(casual)
                ).build()
        );

        // Crear y guardar el producto
        Producto p = Producto.builder()
                .nombre("Pantalón")
                .descripcion("Pantalón vaquero")
                .pvp(12.45)
                .categoria(hombre)
                .build();

        productoRepository.save(p);

        // Verificar los datos guardados
        productoRepository.findAll().forEach(System.out::println);

    }

}
