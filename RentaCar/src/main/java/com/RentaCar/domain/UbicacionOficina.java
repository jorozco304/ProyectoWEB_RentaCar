
package com.RentaCar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ubicacionoficina")
public class UbicacionOficina {
    
    private int id;
    private String nombre;
    private String direccion;

    public UbicacionOficina(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
 
}
