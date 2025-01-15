package com.salesianos.data.controller;

import com.salesianos.data.dto.EditLibroCmd;
import com.salesianos.data.dto.GetLibroDto;
import com.salesianos.data.service.LibroService;
import com.salesianos.data.model.Libro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro/")
@RequiredArgsConstructor
@Tag(name = "Libro", description = "El controlador de libros")
public class LibroController {

    private final LibroService libroService;

    @Operation(summary = "Obtiene todos los libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado libros",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Libro.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 1,
                                                            "nombre": "Libro 3",
                                                            "precio": 34.45,
                                                            "autorId": {
                                                                "id": 1,
                                                                "nombre": "Autor 1"
                                                            }
                                                }                                            
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún libro",
                    content = @Content),
    })
    @GetMapping
    public List<GetLibroDto> getAll() {
        return libroService.findAll()
                .stream()
                .map(GetLibroDto::of)
                .toList();
    }

    /*
    @GetMapping("/product")
    public List<Producto> getAllProduct() {
        return productoService.findAll();
    }
     */

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Libro> create(@RequestBody EditLibroCmd nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        libroService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Libro edit(@RequestBody EditLibroCmd aEditar,
                         @PathVariable Long id) {
        return libroService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
