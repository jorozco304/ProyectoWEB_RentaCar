package com.RentaCar.serviceImpl;

import com.RentaCar.dao.AutoDao;
import com.RentaCar.domain.Auto;
import com.RentaCar.domain.Categoria;
import com.RentaCar.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;


    @Override
    @Transactional(readOnly = true)
    public List<Auto> getAutos(Categoria categoriaAuto) {
        List<Auto> listaAutos = autoDao.findAll();

        //Autos en Renta
        if (categoriaAuto.getCategoriaId() == 1) {
            listaAutos.removeIf(categoriaauto -> categoriaauto.getCategoria().getCategoriaId() != 1);
        }
        //Autos en Venta
        if (categoriaAuto.getCategoriaId() == 2) {
            listaAutos.removeIf(categoriaauto -> categoriaauto.getCategoria().getCategoriaId() != 2);
        }

        return listaAutos;
    }

    @Override
    public void save(Auto auto) {
        autoDao.save(auto);
    }

    @Override
    public void delete(Auto auto) {
        autoDao.delete(auto);
    }
}
