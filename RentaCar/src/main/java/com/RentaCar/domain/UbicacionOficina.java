
package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ubicacion_oficina")
public class UbicacionOficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String direccion;
    private String url;

    public UbicacionOficina(String nombre, String direccion, String url) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.url = url;
    }
 
}
