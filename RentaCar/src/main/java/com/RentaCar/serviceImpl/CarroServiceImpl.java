package com.RentaCar.serviceImpl;

import com.RentaCar.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.RentaCar.dao.CarroDao;
import com.RentaCar.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroDao carroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Carro> getCarros(boolean activos) {
        List<Carro> carros = carroDao.findAll();
        if (activos) {
            carros.removeIf(c -> !c.isActivo());
        }
        return carros;
    }

    @Override
    @Transactional(readOnly = true)
    public Carro getCarro(Carro carro) {
        return carroDao.findById(carro.getIdCarro()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Carro carro) {
        carroDao.save(carro);
    }

    @Override
    @Transactional
    public void delete(Carro carro) {
        carroDao.delete(carro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carro> findByPrecioBetweenOrderByDetalle(double precioInf, double precioSup) {
        return carroDao.findByPrecioBetweenOrderByDetalle(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Carro> metodoJPQL(double precioInf, double precioSup) {
        return carroDao.metodoJPQL(precioInf, precioSup);
    }
    
     @Override
    @Transactional(readOnly=true)    
    public List<Carro> metodoNativo(double precioInf, double precioSup) {
        return carroDao.metodoNativo(precioInf, precioSup);
    }
}
