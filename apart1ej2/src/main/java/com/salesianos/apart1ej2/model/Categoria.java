package com.salesianos.apart1ej2.model;

import com.salesianos.apart1ej2.repository.CategoriaRepository;
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
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_categoria_categoria"))
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> producto = new ArrayList<>();

    // Métodos helpers
    public void addProducto(Producto p) {
        p.setCategoria(this);
        this.getProducto().add(p);
    }

    public void removeProducto(Producto p) {
        this.getProducto().remove(p);
        p.setCategoria(null);
    }

}
