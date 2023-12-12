
package com.RentaCar.controller;

import com.RentaCar.domain.Modelo;
import com.RentaCar.service.ModeloService;
import com.RentaCar.serviceImpl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/modelo")
public class ModeloController {
    
    @Autowired
    private ModeloService modeloService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Modelo> listadoModelos = modeloService.getModelos(false);
        model.addAttribute("modelos", listadoModelos);
        model.addAttribute("totalModelos", listadoModelos.size());
        return "/modelo/listado";
    }
    
    @GetMapping("/nuevo")
    public String modeloNuevo(Modelo modelo) {
        return "/modelo/modifica";
    }
    
    @PostMapping("/guardar")
    public String modeloGuardar(Modelo modelo) {   
        modeloService.save(modelo);
        return "redirect:/modelo/listado";
    }

    @GetMapping("/eliminar/{idModelo}")
    public String modeloEliminar(Modelo modelo) {
        modeloService.delete(modelo);
        return "redirect:/modelo/listado";
    }

    @GetMapping("/modificar/{idModelo}")
    public String modeloModificar(Modelo modelo, Model model) {
        modelo = modeloService.getModelo(modelo);
        model.addAttribute("modelo", modelo);
        return "/modelo/modifica";
    }
    
}