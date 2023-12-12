
package com.RentaCar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Long idModelo; 
    private String marca;
    private String modelo;
    private String color;
    private String anio;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_modelo", insertable = false, updatable = false)
    List<Carro> carros;

    public Modelo() {
    }

    public Modelo(String marca, String modelo, String color, String anio, boolean activo, List<Carro> carros) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.activo = activo;
        this.carros = carros;
    }
}
