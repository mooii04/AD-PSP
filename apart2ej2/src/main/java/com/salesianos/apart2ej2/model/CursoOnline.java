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
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    //La que no esta en el rombo gestiona el ciclo de vida, lleva cascade all
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

    // Helpers
    public void addVideo(Video v) {
        this.videos.add(v);
        v.setCursoOnline(this);
    }

    public void removeVideo(Video v) {
        this.videos.remove(v);
        v.setCursoOnline(null);
    }

}
