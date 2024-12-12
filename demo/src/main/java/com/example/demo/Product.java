package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data es una anotación de Lombok que genera automáticamente los getters, setters, toString, equals y hashCode
@Data
// @NoArgsConstructor es una anotación de Lombok que genera automáticamente un constructor sin argumentos
@NoArgsConstructor
// @AllArgsConstructor es una anotación de Lombok que genera automáticamente un constructor con todos los argumentos
@AllArgsConstructor
// @Builder es una anotación de Lombok que genera automáticamente un constructor con todos los argumentos
@Builder
public class Product {

    private Long id;
    private String name;
    private double price;

    //Modelo anémico



}
