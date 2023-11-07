package com.RentaCar.dao;

import com.RentaCar.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioDao extends JpaRepository<Socio, Long> {
    
}
