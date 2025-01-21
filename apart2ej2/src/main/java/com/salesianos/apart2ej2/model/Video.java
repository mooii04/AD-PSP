package com.salesianos.apart2ej2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@IdClass(VideoPk.class)
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "cursoOnlineId", insertable = false, updatable = false)
    private CursoOnline cursoOnline;

    private int orden;

    private String titulo;

    private String descripcion;

    private String url;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Video video = (Video) o;
        return getId() != null && Objects.equals(getId(), video.getId())
                && getCursoOnline() != null && Objects.equals(getCursoOnline(), video.getCursoOnline());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, cursoOnline);
    }
}
