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
                .telefono("123456789")
                .dni("12345678A")
                .fechaNacimiento(java.time.LocalDate.of(1990, 1, 1))
                .fechaAlta(java.time.LocalDate.of(2021, 1, 1))
                .cuota(0)
                .build();

        Socio s2 = Socio.builder()
                .nombre("Antonio")
                .apellidos("González")
                .email("antonio@gmail.com")
                .telefono("987654321")
                .dni("87654321B")
                .fechaNacimiento(java.time.LocalDate.of(1980, 1, 1))
                .fechaAlta(java.time.LocalDate.of(2020, 1, 1))
                .cuota(0)
                .build();

        SocioAsociado sa1 = SocioAsociado.builder()
                .nombre("María")
                .apellidos("Martínez")
                .email("maria@gmail.com")
                .telefono("456789123")
                .dni("45678912C")
                .fechaNacimiento(java.time.LocalDate.of(2000, 1, 1))
                .fechaAlta(java.time.LocalDate.of(2022, 1, 1))
                .cuota(50)
                .asiento("A1")
                .fechaAbono("2022-01-01")
                .build();

        SocioAsociado sa2 = SocioAsociado.builder()
                .nombre("Ana")
                .apellidos("Gómez")
                .email("ana@gmail.com")
                .telefono("789123456")
                .dni("78912345D")
                .fechaNacimiento(java.time.LocalDate.of(2010, 1, 1))
                .fechaAlta(java.time.LocalDate.of(2023, 1, 1))
                .cuota(100)
                .asiento("B2")
                .fechaAbono("2023-01-01")
                .build();

        socioRepository.save(s1);
        socioRepository.save(s2);
        socioAsociadoRepository.save(sa1);
        socioAsociadoRepository.save(sa2);

        System.out.println("Socios normales");
        //solo los normales no los asociados
        socioRepository.findAll().stream().filter(s -> !(s instanceof SocioAsociado)).forEach(System.out::println);

        System.out.println("Socios asociados");
        socioAsociadoRepository.findAll().forEach(System.out::println);

    }

}
