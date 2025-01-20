package com.salesianos.apart2ej2.util;

import com.salesianos.apart2ej2.model.CursoOnline;
import com.salesianos.apart2ej2.model.Profesor;
import com.salesianos.apart2ej2.model.Video;
import com.salesianos.apart2ej2.repository.CursoOnlineRepository;
import com.salesianos.apart2ej2.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CursoOnlineRepository cursoOnlineRepository;
    private final ProfesorRepository profesorRepository;

    @PostConstruct
    public void run() {

        Profesor p1 = Profesor.builder()
                .nombre("Profesor 1")
                .email("prof.gmail.com")
                .puntuacion(4.5)
                .build();

        Profesor p2 = Profesor.builder()
                .nombre("Profesor 2")
                .email("prof2.gmail.com")
                .puntuacion(4.7)
                .build();

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Curso 1")
                .puntuacion(4.5)
                .profesor(p1)
                .build();

        CursoOnline c2 = CursoOnline.builder()
                .nombre("Curso 2")
                .puntuacion(4.7)
                .profesor(p2)
                .build();

        Video v1 = Video.builder()
                .orden(1L)
                .titulo("Video 1")
                .descripcion("Descripcion 1")
                .url("url1")
                .cursoOnline(c1)
                .build();

        Video v2 = Video.builder()
                .orden(2L)
                .titulo("Video 2")
                .descripcion("Descripcion 2")
                .url("url2")
                .cursoOnline(c1)
                .build();

        profesorRepository.save(p1);
        profesorRepository.save(p2);
        cursoOnlineRepository.save(c1);
        cursoOnlineRepository.save(c2);


        System.out.println("Profesor 1: " + p1);
        System.out.println("Profesor 2: " + p2);
        System.out.println("Curso 1: " + c1);
        System.out.println("Curso 2: " + c2);
        System.out.println("Video 1: " + v1);
        System.out.println("Video 2: " + v2);

    }

}
