
package com.RentaCar.service;

import com.RentaCar.domain.ContenidoSoporte;
import java.util.List;


public interface ContenidoSoporteService {
    
    public List<ContenidoSoporte> getContenidoSoportes(boolean activos);
    
    public ContenidoSoporte getContenidoSoporte(ContenidoSoporte contenidoSoporte);

    public void save(ContenidoSoporte contenidoSoporte);

    public void delete(ContenidoSoporte contenidoSoporte);
    
}
