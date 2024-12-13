package com.example.demo.service;

import com.example.demo.ProductRepository;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class productService {

    private final ProductRepository productRepository;

    public List<Product> getAll();{
        List<Product> result = productRepository.getAll();

        if(result.isEmpty()){
            throw new ProductNotFoundException();
        }

        return ResponseEntity.ok(result);
    }

    public List<Product> query(double maxPrice, String sortDirection){s
        List<Product> result = productRepository.query(maxPrice, sortDirection);

        if(result.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se han encontrados productos");

        return ResponseEntity.ok(result);
    }

    public Product add(Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRepository.add(product));
    }s



}
