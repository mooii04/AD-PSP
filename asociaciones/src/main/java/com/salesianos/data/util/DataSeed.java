package com.salesianos.data.util;

import com.salesianos.data.model.Autor;
import com.salesianos.data.model.Libro;
import com.salesianos.data.repository.AutorRepository;
import com.salesianos.data.repository.LibroRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    @PostConstruct
    public void run () {

        //Categoria c = categoriaRepository.getReferenceById(1L);

        //No hacer orElse null, hacerlo mejor con Optional!!!!!
        Autor a = null;
        Optional<Autor> autorOptional = autorRepository.findById(1L);

        if (autorOptional.isPresent()) {
            a = autorOptional.get();
        }

        Libro l1 = Libro.builder()
                .nombre("Libro 1")
                .descripcion("Descripción del libro 1")
                .precio(12.34)
                //.categoria(c)
                .build();

        a.addLibro(l1);

        libroRepository.save(l1);

        Libro l2 = Libro.builder()
                .nombre("Libro 2")
                .descripcion("Descripción del libro 2")
                .precio(23.45)
                //.categoria(c)
                .build();

        a.addLibro(l2);

        libroRepository.save(l2);

        System.out.println("Libros del Autor C1");
        System.out.println(a.getLibros());

        libroRepository.findAll()
                .forEach(System.out::println);

    }

}
