package com.RentaCar.service;


import com.RentaCar.domain.Auto;
import com.RentaCar.domain.Categoria;

import java.util.List;


public interface AutoService {

    public List<Auto> getAutos(Categoria categoriaAuto);

    public void save(Auto auto);

    public void delete(Auto auto);


}