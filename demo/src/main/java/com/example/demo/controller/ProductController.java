package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// @RestController es una anotación de Spring que combina @Controller y @ResponseBody, dos anotaciones que se utilizan comúnmente en controladores de Spring
@RestController
// @RequestMapping es una anotación de Spring que se utiliza para asignar solicitudes web a métodos de controladores específicos
@RequestMapping("/product/")
// @RequiredArgsConstructor es una anotación de Lombok que genera automáticamente un constructor con todos los argumentos
@RequiredArgsConstructor
public class ProductController {

    // @Autowired es una anotación de Spring que se utiliza para inyectar dependencias automáticamente
    // @Autowired
    private final ProductRepository productRepository;

    /*
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){

        1. Obtener del repositorio la lista de productos
        2. Si la lista está vacía, devolver 404
        3. Si la lista tiene productos, devolver 200 con la lista


        List<Product> result = productRepository.getAll();

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
    */

    @GetMapping
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
                                                @RequestParam(required = false, value = "sortName", defaultValue = "no") String sortDirection){
        List<Product> result = productRepository.query(max, sortDirection);

        if(result.isEmpty())
            //return ResponseEntity.notFound().build();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se han encontrados productos");

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRepository.add(product));
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.of(productRepository.get(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.of(productRepository.edit(id, product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productRepository.delete(id);
        return ResponseEntity.noContent().build();
    }



}
