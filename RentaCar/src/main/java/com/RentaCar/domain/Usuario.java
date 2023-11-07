package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    private String nombre;
    private String correo;
    private String contrasenha;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String pais;
    private String fotoPerfil;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Usuario(String nombre, String correo, String contrasenha, Categoria categoria, Date fechaNacimiento, String direccion,
                   String telefono, String ciudad, String pais, String fotoPerfil) {

        this.nombre = nombre;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.categoria = categoria;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fotoPerfil = fotoPerfil;
    }
}


