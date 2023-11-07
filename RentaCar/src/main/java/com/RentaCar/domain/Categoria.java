package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "categorias")
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;
    private String nombre;


    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}

