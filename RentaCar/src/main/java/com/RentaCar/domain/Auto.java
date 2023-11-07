package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autoId;

    private String marca;
    private String modelo;
    private String anhio;
    private double precio;
    private boolean disponible;
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Auto(String marca, String modelo, String anhio, double precio, boolean disponible, String rutaImagen, Categoria categoria) {
        this.marca = marca;
        this.modelo = modelo;
        this.anhio = anhio;
        this.precio = precio;
        this.disponible = disponible;
        this.rutaImagen = rutaImagen;
        this.categoria = categoria;
    }
}
