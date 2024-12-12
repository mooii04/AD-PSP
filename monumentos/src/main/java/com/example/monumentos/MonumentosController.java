package com.example.monumentos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
public class MonumentosController {

    private final MonumentosRepository monumentosRepository;

    @GetMapping
    public ResponseEntity<List<Monumentos>> getAll(@RequestParam(required = false, value = "maxLatitud", defaultValue = "-10000") double max,
                                                   @RequestParam(required = false, value = "sortName", defaultValue = "no") String sortDirection) {
        List<Monumentos> result = monumentosRepository.query(max, sortDirection);

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Monumentos> create(@RequestBody Monumentos monumentos) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentosRepository.add(monumentos));
    }

    @GetMapping("{id}")
    public ResponseEntity<Monumentos> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentosRepository.get(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Monumentos> update(@PathVariable Long id, @RequestBody Monumentos monumentos) {
        return ResponseEntity.of(monumentosRepository.edit(id, monumentos));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentosRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
