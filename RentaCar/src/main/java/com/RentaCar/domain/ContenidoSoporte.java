
package com.RentaCar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contenidosoporte")
public class ContenidoSoporte {
    
    private int id;
    private String titulo;
    private String descripcion;

    public ContenidoSoporte(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    
}
