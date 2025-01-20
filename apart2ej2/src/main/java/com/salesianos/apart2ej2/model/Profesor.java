package com.salesianos.apart2ej2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<CursoOnline> cursos = new ArrayList<>();

    // Helpers
    public void addCurso(CursoOnline c) {
        this.cursos.add(c);
        c.setProfesor(this);
    }

    public void removeCurso(CursoOnline c) {
        this.cursos.remove(c);
        c.setProfesor(null);
    }

}
