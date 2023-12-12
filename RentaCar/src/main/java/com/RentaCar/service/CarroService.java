package com.RentaCar.service;


import com.RentaCar.domain.Carro;

import java.util.List;


public interface CarroService {


    public List<Carro> getCarros(boolean activos);
    
    public Carro getCarro(Carro carro);
    
    public void save (Carro carro);
    
    public void delete (Carro carro);

    public List<Carro> findByPrecioBetweenOrderByDetalle(double precioInf, double precioSup);
    
    public List<Carro> metodoJPQL(double precioInf, double precioSup);
    
    public List<Carro> metodoNativo(double precioInf, double precioSup);


}