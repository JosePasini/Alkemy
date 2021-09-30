package com.example.alkemy_disney.entities;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import net.bytebuddy.build.ToStringPlugin;
import org.hibernate.collection.internal.PersistentBag;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String imagen;
    private String titulo;
    private Date fecha;
    private int calificacion;

    @FieldNameConstants.Exclude
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "peliculas")
    private List<Personaje> personajes;// = new ArrayList<>();

/*

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_genero")
    private Genero genero;
*/

}
