package com.example.demo.dto;

import com.example.demo.model.Product;

public record CreateProductDto(
        String name,
        double price
) {

    public static CreateProductDto of(String name, double price) {
        return new CreateProductDto(name, price);
    }

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }

}
