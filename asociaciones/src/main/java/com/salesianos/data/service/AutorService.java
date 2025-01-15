package com.salesianos.data.service;

import com.salesianos.data.model.Autor;
import com.salesianos.data.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> findAll() {
        List<Autor> result = autorRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay autores con esos criterios de búsqueda");
        return result;
    }

    public Autor findById(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay autor con ID: "+ id));

    }

    public Autor save (Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor edit(Autor autor, Long id) {
        return autorRepository.findById(id)
                .map(old -> {
                    old.setNombre(autor.getNombre());
                    return autorRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay autor con ID: "+ id));

    }

    public void delete(Long id) {
        autorRepository.deleteById(id);
    }

}
