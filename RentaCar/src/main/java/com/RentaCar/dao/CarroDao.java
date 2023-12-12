package com.RentaCar.dao;

import com.RentaCar.domain.Carro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarroDao extends JpaRepository<Carro, Long> {
    
        //Ejemplo de método utilizando Métodos de Query
    public List<Carro> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Carro a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Carro> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM carro where carro.precio BETWEEN :precioInf AND :precioSup ORDER BY carro.descripcion ASC")
    public List<Carro> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup); 
}
