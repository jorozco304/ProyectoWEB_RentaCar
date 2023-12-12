package com.RentaCar.domain;

import jakarta.persistence.*;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservaId;

    private Usuario usuarioId;
    private Carro autoId;
        
    @Temporal(TemporalType.DATE)
    private Date fechaReservaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaReservaFinal;

    public Reserva(Usuario usuarioId, Carro autoId, Date fechaReservaInicio, Date fechaReservaFinal) {

        this.usuarioId = usuarioId;
        this.autoId = autoId;
        this.fechaReservaInicio = fechaReservaInicio;
        this.fechaReservaFinal = fechaReservaFinal;
    }
    
    
    
}
