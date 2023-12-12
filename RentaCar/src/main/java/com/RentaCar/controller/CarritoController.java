
package com.RentaCar.controller;

import com.RentaCar.domain.Carro;
import com.RentaCar.domain.Item;
import com.RentaCar.service.CarroService;
import com.RentaCar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private CarroService carroService;
    

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalAlquiler = 0;
        for (Item i : items) {
            carritoTotalAlquiler += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalAlquiler);
        return "/carrito/listado";
    }    
   

    @GetMapping("/carrito/agregar/{idCarro}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Carro carro = carroService.getCarro(item);
            item2 = new Item(carro);
        }
        itemService.save(item2);
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


    @GetMapping("/carrito/modificar/{idCarro}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }


    @GetMapping("/carrito/eliminar/{idCarro}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }


    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}