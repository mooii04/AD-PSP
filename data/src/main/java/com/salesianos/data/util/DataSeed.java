package com.salesianos.data.util;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Producto;
import com.salesianos.data.repository.CategoriaRepository;
import com.salesianos.data.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run () {

        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p1 = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                .categoria(c)
                .build();

        repo.save(p1);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(123.45)
                .categoria(c)
                .build();

        repo.save(p2);

    }

}
