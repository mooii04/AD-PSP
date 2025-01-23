package com.salesianos.HerenciaEjClase.singleTable;

import com.salesianos.HerenciaEjClase.singleTable.model.Socio;
import com.salesianos.HerenciaEjClase.singleTable.model.SocioAsociado;
import com.salesianos.HerenciaEjClase.singleTable.repository.SocioAsociadoRepository;
import com.salesianos.HerenciaEjClase.singleTable.repository.SocioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedSingleTable {

    private final SocioRepository socioRepository;
    private final SocioAsociadoRepository socioAsociadoRepository;

    @PostConstruct
    public void run(){

        Socio s1 = Socio.builder()
                .nombre("Manuel")
                .apellidos("García")
                .email("manuel@gmail.com")
                .build();

        Socio s2 = Socio.builder()
                .nombre("Antonio")
                .apellidos("González")
                .email("antonio@gmail.com")
                .build();

        SocioAsociado sa1 = SocioAsociado.builder()
                .nombre("María")
                .apellidos("Martínez")
                .email("maria@gmail.com")
                .cuota(50)
                .build();

        SocioAsociado sa2 = SocioAsociado.builder()
                .nombre("Ana")
                .apellidos("Gómez")
                .email("ana@gmail.com")
                .cuota(100)
                .build();

        socioRepository.save(s1);
        socioRepository.save(s2);
        socioAsociadoRepository.save(sa1);
        socioAsociadoRepository.save(sa2);

        System.out.println("Socios normales");
        socioRepository.findAll().forEach(System.out::println);
        System.out.println("Socios asociados");
        socioAsociadoRepository.findAll().forEach(System.out::println);

    }

}
