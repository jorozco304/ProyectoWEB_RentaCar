/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.RentaCar.service;

import com.RentaCar.domain.UbicacionOficina;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UbicacionOficinaService {

    public List<UbicacionOficina> getUbicacionOficinas(boolean activos);
    
    public UbicacionOficina getUbicacionOficina(UbicacionOficina ubicacionOficina);

    public void save(UbicacionOficina ubicacionOficina);

    public void delete(UbicacionOficina ubicacionOficina);    
}
