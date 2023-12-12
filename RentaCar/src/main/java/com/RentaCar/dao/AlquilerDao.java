package com.RentaCar.dao;

import com.RentaCar.domain.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerDao extends JpaRepository<Alquiler, Long> {
    
}
