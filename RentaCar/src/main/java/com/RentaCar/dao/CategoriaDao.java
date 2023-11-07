package com.RentaCar.dao;

import com.RentaCar.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
}
