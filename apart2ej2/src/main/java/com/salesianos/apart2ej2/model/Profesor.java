package com.salesianos.apart2ej2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private int puntuacion;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "profesor",
            fetch = FetchType.EAGER
    )
    private List<CursoOnline> cursos = new ArrayList<>();

    public void addCursoOnline(CursoOnline curso){
        curso.setProfesor(this);
        this.getCursos().add(curso);
    }

    public void deleteCursoOnline(CursoOnline curso){
        this.getCursos().remove(curso);
        curso.setProfesor(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}