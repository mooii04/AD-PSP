package com.salesianos.data.service;

import com.salesianos.data.dto.EditLibroCmd;
import com.salesianos.data.model.Libro;
import com.salesianos.data.repository.AutorRepository;
import com.salesianos.data.repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public List<Libro> findAll() {
        /*
            Obtener todos los productos
            Si la lista está vacía
                Lanzo excepción
         */
        List<Libro> result = libroRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos con esos criterios de búsqueda");
        return result;
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }

    public Libro save(EditLibroCmd nuevo) {
        return libroRepository.save(Libro.builder()
                .nombre(nuevo.nombre())
                .precio(nuevo.precio())
                //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                .autor(autorRepository.findById(nuevo.autorId()).orElse(null))
                .descripcion(nuevo.descripcion())
                .build());
    }

    public Libro edit(EditLibroCmd editProductoCmd, Long id) {
        return libroRepository.findById(id)
                .map(old -> {
                    old.setNombre(editProductoCmd.nombre());
                    old.setDescripcion(editProductoCmd.descripcion());
                    old.setPrecio(editProductoCmd.precio());
                    //old.setCategoria(categoriaRepository.getReferenceById(editProductoCmd.categoriaId()));
                    old.setAutor(autorRepository.findById(editProductoCmd.autorId()).orElse(null));
                    return libroRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));

    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

}
