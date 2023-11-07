package com.RentaCar.domain;

import jakarta.persistence.*;

import java.sql.Date;

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservaId;

    private Usuario usuarioId;
    private Auto autoId;
        
    @Temporal(TemporalType.DATE)
    private Date fechaReservaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaReservaFinal;

    public Reserva(Usuario usuarioId, Auto autoId, Date fechaReservaInicio, Date fechaReservaFinal) {

        this.usuarioId = usuarioId;
        this.autoId = autoId;
        this.fechaReservaInicio = fechaReservaInicio;
        this.fechaReservaFinal = fechaReservaFinal;
    }
    
    
    
}
