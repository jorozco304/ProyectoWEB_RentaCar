
package com.RentaCar.service;

import com.RentaCar.domain.Modelo;
import java.util.List;


public interface ModeloService {
    
    public List<Modelo> getModelos(boolean activos);
    
    public Modelo getModelo(Modelo modelo);

    public void save(Modelo modelo);

    public void delete(Modelo modelo);
}
