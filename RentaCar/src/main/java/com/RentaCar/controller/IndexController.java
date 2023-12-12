package com.RentaCar.controller;

import com.RentaCar.domain.Item;
import com.RentaCar.service.CarroService;
import com.RentaCar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    CarroService carroService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String page(Model model) {
        var listaCarros = carroService.getCarros(true);
        model.addAttribute("carros", listaCarros);
        return "index";
    }

    @RequestMapping("/refrescarBoton")
    public ModelAndView refrescarBoton(Model model) {
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalAlquiler = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalAlquiler += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalAlquiler);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

}
