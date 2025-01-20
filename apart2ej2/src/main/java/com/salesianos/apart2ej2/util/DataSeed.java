package com.salesianos.apart2ej2.util;

import com.salesianos.apart2ej2.model.CursoOnline;
import com.salesianos.apart2ej2.model.Profesor;
import com.salesianos.apart2ej2.model.Video;
import com.salesianos.apart2ej2.repository.CursoOnlineRepository;
import com.salesianos.apart2ej2.repository.ProfesorRepository;
import com.salesianos.apart2ej2.repository.VideoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CursoOnlineRepository cursoOnlineRepository;
    private final ProfesorRepository profesorRepository;
    private final VideoRepository videoRepository;

    @PostConstruct
    public void run() {

        Profesor profesor1 = Profesor.builder()
                .nombre("Juan Pérez")
                .email("juan@gamil.com")
                .puntuacion(4.5)
                .build();

        profesorRepository.save(profesor1);

        CursoOnline curso1 = CursoOnline.builder()
                .nombre("Java Básico")
                .puntuacion(4.7)
                .profesor(profesor1)
                .build();

        cursoOnlineRepository.save(curso1);

        Video video1 = Video.builder()
                .orden(1L)
                .titulo("Introducción a Java")
                .descripcion("Conceptos básicos de Java")
                .url("http://example")
                .cursoOnline(curso1)
                .build();

        videoRepository.save(video1);

        Video video2 = Video.builder()
                .orden(2L)
                .titulo("Variables y tipos de datos")
                .descripcion("Variables y tipos de datos en Java")
                .url("http://example")
                .cursoOnline(curso1)
                .build();

        videoRepository.save(video2);


        System.out.println("Lista de profesores:");
        profesorRepository.findAll().forEach(System.out::println);

        System.out.println("Lista de cursos:");
        cursoOnlineRepository.findAll().forEach(System.out::println);

        System.out.println("Lista de videos:");
        videoRepository.findAll().forEach(System.out::println);

    }

}
