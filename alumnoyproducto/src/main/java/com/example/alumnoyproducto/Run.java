package com.example.alumnoyproducto;

import com.example.alumnoyproducto.alumno.Alumno;
import com.example.alumnoyproducto.alumno.AlumnoDto;
import com.example.alumnoyproducto.alumno.Curso;
import com.example.alumnoyproducto.alumno.Direccion;
import com.example.alumnoyproducto.producto.Categoria;
import com.example.alumnoyproducto.producto.Producto;
import com.example.alumnoyproducto.producto.ProductoDto;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Run {

    @PostConstruct
    public static void main(String[] args) {

        Categoria categoria = new Categoria(1L, "Electrónica");
        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Maleta")
                .desc("Maleta de 4 ruedas, color azul")
                .pvp(69.99)
                .imagenes(Arrays.asList("imagen1.jpg", "imagen2.jpg"))
                .categoria(categoria)
                .build();

        ProductoDto productoDto = ProductoDto.toProducto(producto);

        //ALUMNO
        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Plaza")
                .linea1("Plaza del Marqués")
                .linea2("nº 13")
                .cp("41950")
                .poblacion("Castilleja de la Cuesta")
                .provincia("Sevilla")
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("Base de Datos")
                .tipo("Informática")
                .tutor("Luismi")
                .aula("1º DAM")
                .build();

        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Moisés")
                .apellido1("Dorado")
                .apellido2("Gutiérrez")
                .email("dorado.gumoi24@triana.salesianos.edu")
                .curso(curso)
                .direccion(direccion)
                .build();


        AlumnoDto alumnoDto = AlumnoDto.toAlumno(alumno);

        System.out.println(productoDto);
        System.out.println(alumnoDto);

    }

}
