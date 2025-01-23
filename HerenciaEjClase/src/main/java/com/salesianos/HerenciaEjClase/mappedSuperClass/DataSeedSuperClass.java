package com.salesianos.HerenciaEjClase.mappedSuperClass;

import com.salesianos.HerenciaEjClase.mappedSuperClass.model.Movil;
import com.salesianos.HerenciaEjClase.mappedSuperClass.model.Ordenador;
import com.salesianos.HerenciaEjClase.mappedSuperClass.repository.ElectronicaRepository;
import com.salesianos.HerenciaEjClase.mappedSuperClass.repository.MovilRepository;
import com.salesianos.HerenciaEjClase.mappedSuperClass.repository.OrdenadorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeedSuperClass {

    private final ElectronicaRepository electronicaRepository;
    private final MovilRepository movilRepository;
    private final OrdenadorRepository ordenadorRepository;

    @PostConstruct
    public void run () {

        Movil m1 = new Movil(500, "Samsung", "Galaxy S21");
        Movil m2 = new Movil(300, "Xiaomi", "Redmi Note 9");
        Movil m3 = new Movil(1000, "Apple", "iPhone 12");

        movilRepository.save(m1);
        movilRepository.save(m2);
        movilRepository.save(m3);

        Ordenador o1 = new Ordenador(800, "Intel i7", "16GB", "Nvidia RTX 3060");
        Ordenador o2 = new Ordenador(1200, "AMD Ryzen 9", "32GB", "Nvidia RTX 3080");
        Ordenador o3 = new Ordenador(600, "Intel i5", "8GB", "Nvidia GTX 1660");

        ordenadorRepository.save(o1);
        ordenadorRepository.save(o2);
        ordenadorRepository.save(o3);

        System.out.println("Móviles: ");
        movilRepository.findAll().forEach(System.out::println);
        System.out.println("Ordenadores: ");
        ordenadorRepository.findAll().forEach(System.out::println);

    }

}
