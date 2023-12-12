package com.RentaCar.serviceImpl;

import com.RentaCar.dao.ModeloDao;
import com.RentaCar.domain.Modelo;
import com.RentaCar.service.ModeloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloServiceImpl implements ModeloService {

    @Autowired
    private ModeloDao modeloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Modelo> getModelos(boolean activos) {
        List<Modelo> modelos = modeloDao.findAll();
        if (activos){
            modelos.removeIf(c -> !c.isActivo());
        }
        return modelos;
    }

    @Override
    public Modelo getModelo(Modelo modelo) {
        return modeloDao.findById(modelo.getIdModelo()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Modelo modelo) {
        modeloDao.save(modelo);
    }

    @Override
    @Transactional
    public void delete(Modelo modelo) {
        modeloDao.delete(modelo);
    }
}
