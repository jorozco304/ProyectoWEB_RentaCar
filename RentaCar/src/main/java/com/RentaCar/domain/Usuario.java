package com.RentaCar.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long usuarioId;

    private String nombre;
    private String correo;
    private String contrasenha;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String direccion;
    private String telefono;
    private String ciudad;
    private String pais;
    private String fotoPerfil;
    private String tipoLicencia;


    public Usuario(String nombre, String correo, String contrasenha, Date fechaNacimiento, String direccion,
                   String telefono, String ciudad, String pais, String fotoPerfil, String tipoLicencia) {

        this.nombre = nombre;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fotoPerfil = fotoPerfil;
        this.tipoLicencia = tipoLicencia;
    }
}


