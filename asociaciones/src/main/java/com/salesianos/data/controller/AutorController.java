package com.salesianos.data.controller;

import com.salesianos.data.dto.GetAutorDto;
import com.salesianos.data.model.Autor;
import com.salesianos.data.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor/")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public List<GetAutorDto> getAll() {
        return autorService.findAll()
                .stream()
                .map(GetAutorDto::fromAutor)
                .toList();
    }

    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.save(autor));
    }

    @PutMapping("/{id}")
    public Autor edit(@RequestBody Autor autor, @PathVariable Long id) {
        return autorService.edit(autor, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
