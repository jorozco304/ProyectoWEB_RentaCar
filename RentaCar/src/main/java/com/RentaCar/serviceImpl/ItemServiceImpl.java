
package com.RentaCar.serviceImpl;

import com.RentaCar.dao.AlquilerDao;
import com.RentaCar.dao.CarroDao;
import com.RentaCar.dao.FacturaDao;
import com.RentaCar.domain.Alquiler;
import com.RentaCar.domain.Carro;
import com.RentaCar.domain.Factura;
import com.RentaCar.domain.Item;
import com.RentaCar.domain.Usuario;
import com.RentaCar.service.ItemService;
import com.RentaCar.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdCarro(), item.getIdCarro())) {
                if (i.getCantidad() < item.getExistencias()) {
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdCarro(), item.getIdCarro())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdCarro(), item.getIdCarro())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdCarro(), item.getIdCarro())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService uuarioService;
    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private AlquilerDao alquilerDao;
    @Autowired
    private CarroDao carroDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");

        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario uuario = uuarioService.getUsuarioPorUsername(username);

        if (uuario == null) {
            return;
        }

        Factura factura = new Factura(uuario.getIdUsuario());
        factura = facturaDao.save(factura);

        double total = 0;
        for (Item i : listaItems) {
            System.out.println("Carro: " + i.getDetalle()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio() * i.getCantidad());
            Alquiler alquiler = new Alquiler(factura.getIdFactura(), i.getIdCarro(), i.getPrecio(), i.getCantidad());
            alquilerDao.save(alquiler);
            Carro carro = carroDao.getReferenceById(i.getIdCarro());
            carro.setExistencias(carro.getExistencias()-i.getCantidad());
            carroDao.save(carro);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
    }
}