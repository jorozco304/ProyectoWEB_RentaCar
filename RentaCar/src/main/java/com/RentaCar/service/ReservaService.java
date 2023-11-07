/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.RentaCar.service;

import com.RentaCar.domain.Reserva;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ReservaService {
    
        public List<Reserva> getReservas(boolean activos);
    
    public Reserva getReserva(Reserva reserva);

    public void save(Reserva reserva);

    public void delete(Reserva reserva);
    
}
