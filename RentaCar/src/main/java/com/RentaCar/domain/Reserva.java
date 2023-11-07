/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.RentaCar.domain;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Reserva {
    
    private int id;
    private int usuario_id;
    private int vehiculo_id;
        
    @Temporal(TemporalType.DATE)
    private Date fecha_reservaInicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_reservaFinal;

    public Reserva(int usuario_id, int vehiculo_id, Date fecha_reservaInicio, Date fecha_reservaFinal) {
        this.usuario_id = usuario_id;
        this.vehiculo_id = vehiculo_id;
        this.fecha_reservaInicio = fecha_reservaInicio;
        this.fecha_reservaFinal = fecha_reservaFinal;
    }
    
    
    
}
