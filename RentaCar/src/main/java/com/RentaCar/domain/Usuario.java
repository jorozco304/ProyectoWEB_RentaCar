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
    private Long id;

   private int usuario_id;
    private String nombre;
    private String correo;
    private String contrasenha;
    private Date fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String pais;
    private String foto_perfil;
    private String tipo_licencia;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public Usuario(Long id, int usuario_id, String nombre, String correo, String contrasenha, Date fecha_nacimiento, String direccion, String telefono, String ciudad, String pais, String foto_perfil, String tipo_licencia, Date fechaNacimiento) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.foto_perfil = foto_perfil;
        this.tipo_licencia = tipo_licencia;
        this.fechaNacimiento = fechaNacimiento;
    }
}


