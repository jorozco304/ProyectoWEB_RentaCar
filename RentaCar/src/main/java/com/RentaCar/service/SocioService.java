/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.RentaCar.service;

import com.RentaCar.domain.Socio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface SocioService {
    
    public List<Socio> getSocios(boolean activos);
    
    public Socio getSocio(Socio socio);

    public void save(Socio socio);

    public void delete(Socio socio);
    
}
