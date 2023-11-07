package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autoId;

    private String marca;
    private String modelo;
    private String tipoVehiculo;
    private boolean disponible;
    private int anio;
    private String placa;
    private String trasmicion;
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Auto(String marca, String modelo, String tipoVehiculo, boolean disponible, int anio, String placa, String trasmicion, String rutaImagen, Categoria categoria) {

        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.disponible = disponible;
        this.anio = anio;
        this.placa = placa;
        this.trasmicion = trasmicion;
        this.categoria = categoria;
    }
 }
