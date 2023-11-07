package com.RentaCar.service;


import com.RentaCar.domain.Auto;

import java.util.List;


public interface AutoService {

    public List<Auto> getAutos(boolean activos);
    
    public Auto getAuto(Auto auto);

    public void save(Auto auto);

    public void delete(Auto auto);


}