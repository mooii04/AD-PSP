package com.salesianos.apart2ej2.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private Long orden;

    private String titulo;

    private String descripcion;

    private String url;

    @ManyToOne
    private CursoOnline cursoOnline;



}
