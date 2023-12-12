package com.RentaCar.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    private Long idCarro;
    private String detalle;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo  modelo;

    public Carro() {
    }

    public Carro(String detalle, double precio, int existencias, String imagen, boolean activo, Categoria categoria, Modelo modelo) {
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.categoria = categoria;
        this.modelo = modelo;
    }

 }
