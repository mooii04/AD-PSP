package com.example.demo.controller;

import com.example.demo.dto.GetProductListDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController es una anotación de Spring que combina @Controller y @ResponseBody, dos anotaciones que se utilizan comúnmente en controladores de Spring
@RestController
// @RequestMapping es una anotación de Spring que se utiliza para asignar solicitudes web a métodos de controladores específicos
@RequestMapping("/product/")
// @RequiredArgsConstructor es una anotación de Lombok que genera automáticamente un constructor con todos los argumentos
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public GetProductListDto getAll(
            @RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        return GetProductListDto.of(
                productService.query(max, sortDirection)
        );
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product));
    }

    @PutMapping("/{id}")
    public Product edit(
            @RequestBody Product product,
            @PathVariable("id") Long productId) {

        return productService.edit(productId, product);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }



}