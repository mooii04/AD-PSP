package com.salesianos.HerenciaEjClase.joined;

import com.salesianos.HerenciaEjClase.joined.model.Concierto;
import com.salesianos.HerenciaEjClase.joined.model.Conferencia;
import com.salesianos.HerenciaEjClase.joined.repository.EventoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedJoined {

    private final EventoRepository eventoRepository;

    @PostConstruct
    public void run(){

        //quiero dos conciertos y dos conferencias
        eventoRepository.save
                (new Concierto
                        ("PETADA", (java.time.LocalDate.of(2004,12,12)), "Sevilla", "Manuel Carrasco", "Pop"));
        eventoRepository.save
                (new Concierto
                        ("BOOM", (java.time.LocalDate.of(2004,12,12)), "Bilbao", "Quevedo", "Reggaeton"));


        eventoRepository.save
                (new Conferencia
                        ("This is Elon Musk", (java.time.LocalDate.of(2004,12,12)), "Sevilla", "Elon Musk", "IA"));
        eventoRepository.save
                (new Conferencia
                        ("Conferencia Nacional PP", (java.time.LocalDate.of(2004,12,12)), "Madrid", "Isabel Díaz Ayuso", "Política"));

        System.out.println("Conciertos");
        eventoRepository.findAll().stream().filter(e -> e instanceof Concierto).forEach(System.out::println);

        System.out.println("Conferencias");
        eventoRepository.findAll().stream().filter(e -> e instanceof Conferencia).forEach(System.out::println);

    }

}
