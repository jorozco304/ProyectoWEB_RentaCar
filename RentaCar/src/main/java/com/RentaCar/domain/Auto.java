package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "vehiculo")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculo_id;

    private String marca;
    private String modelo;
    private String tipo_vehiculo;
    private boolean disponible;
    private int anio;
    private String placa;
    private String trasmicion;
    private String ruta_imagen;

    public Auto(String marca, String modelo, String tipo_vehiculo, boolean disponible, int anio, String placa, String trasmicion, String ruta_imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_vehiculo = tipo_vehiculo;
        this.disponible = disponible;
        this.anio = anio;
        this.placa = placa;
        this.trasmicion = trasmicion;
        this.ruta_imagen = ruta_imagen;
    }
 }
