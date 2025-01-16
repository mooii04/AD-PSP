package com.salesianos.apart1ej2.util;

import com.salesianos.apart1ej2.model.Categoria;
import com.salesianos.apart1ej2.model.Producto;
import com.salesianos.apart1ej2.repository.CategoriaRepository;
import com.salesianos.apart1ej2.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public void run() {

    //quiero un producto con una categoria y dentro de esa categoria otra categoria

        Producto p = Producto.builder()
                .nombre("Pantalón")
                .descripcion("Pantalón vaquero")
                .pvp(12.45)
                .categoria(
                        Categoria.builder()
                                .nombre("Hombre")
                                .categoria(
                                        Categoria.builder()
                                                .nombre("Casual")
                                                .build()
                                )
                                .build()
                )
                .build();

        productoRepository.save(p);

        System.out.println(productoRepository.findAll());

    }

}
