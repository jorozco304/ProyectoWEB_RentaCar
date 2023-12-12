package com.RentaCar.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria; 
    private String descripcion;
    private String imagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    List<Carro> carros;

    public Categoria() {
    }

    public Categoria(String descripcion, String imagen, boolean activo, List<Carro> carros) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
        this.carros = carros;
    }
    
    
}

