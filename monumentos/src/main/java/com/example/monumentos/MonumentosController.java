package com.example.monumentos;

import com.example.monumentos.Monumento;
import com.example.monumentos.MonumentoRepository;
import com.example.monumentos.MonumentoService;
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
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
@Tag(name = "Monumentos", description = "El controlador de monumentos")
public class MonumentosController {

    private final MonumentosRepository monumentosRepository;
    private final MonumentoService monumentoService;

    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumentos.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Sevilla",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "La Giralda",
                                                    "description": "The Giralda is the bell tower of the Seville Cathedral in Seville, Spain. It was originally built as a minaret during the Moorish period, with a Renaissance-style top subsequently added by Spaniards.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG/800px-Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG"
                                                },
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Sevilla",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "La Giralda",
                                                    "description": "The Giralda is the bell tower of the Seville Cathedral in Seville, Spain. It was originally built as a minaret during the Moorish period, with a Renaissance-style top subsequently added by Spaniards.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG/800px-Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG"
                                                }

                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("all")
    public ResponseEntity<List<Monumentos>> getAllWithParams(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {
        List<Monumentos> result = monumentoService.query(latitude, sort);


        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Crea un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumentos.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })


    @PostMapping
    public ResponseEntity<Monumentos> create(
            @RequestBody Monumentos monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.add(monumento));
    }


    @Operation(summary = "Obtiene un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el mounmento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumentos.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Sevilla",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "La Giralda",
                                                    "description": "The Giralda is the bell tower of the Seville Cathedral in Seville, Spain. It was originally built as a minaret during the Moorish period, with a Renaissance-style top subsequently added by Spaniards.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG/800px-Giralda%2C_Sevilla%2C_Espa%C3%B1a%2C_2015-12-08%2C_DD_64-66_HDR.JPG"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("{id}")
    public Monumentos getById(@PathVariable Long id) {
        return monumentoService.get(id);
    }

    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumentos.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @PutMapping("{id}")
    public Monumentos edit(
            @RequestBody Monumentos monumento,
            @PathVariable("id") Long id) {
        return monumentoService.edit(id, monumento);
    }


    @Operation(summary = "Borra un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumentos.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}