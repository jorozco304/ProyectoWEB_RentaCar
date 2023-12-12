
package com.RentaCar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="alquiler")
public class Alquiler implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alquiler")
    private Long idAlquiler;
    private Long idFactura;
    private Long idCarro;    
    private double precio;
    private int cantidad;    

    public Alquiler() {
    }

    public Alquiler(Long idFactura, Long idCarro, double precio, int cantidad) {
        this.idFactura = idFactura;
        this.idCarro = idCarro;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    
    
}
