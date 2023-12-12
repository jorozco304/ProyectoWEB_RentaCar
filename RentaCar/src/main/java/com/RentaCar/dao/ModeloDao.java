
package com.RentaCar.dao;

import com.RentaCar.domain.Modelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModeloDao extends JpaRepository<Modelo, Long>{
    List<Modelo> findByDescripcionContainingIgnoreCase (String descripcion);
}
