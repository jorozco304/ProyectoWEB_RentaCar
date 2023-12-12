package com.RentaCar.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table (name="usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellidos;
    private String correo;
    private String telefono;
    private String imagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
}

