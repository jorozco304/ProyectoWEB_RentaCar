
package com.RentaCar.controller;

import com.RentaCar.domain.Carro;
import com.RentaCar.domain.Categoria;
import com.RentaCar.service.CarroService;
import com.RentaCar.service.CategoriaService;
import com.RentaCar.serviceImpl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/carro")
public class CarroController {
    
    @Autowired
    private CarroService carroService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Carro> listadoCarros = carroService.getCarros(false);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("carros", listadoCarros);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCarros", listadoCarros.size());
        return "/carro/listado";
    }
    
    @GetMapping("/nuevo")
    public String carroNuevo(Carro carro) {
        return "/carro/modifica";
    }
    
    @PostMapping("/guardar")
    public String carroGuardar(Carro carro,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            carroService.save(carro);
            carro.setImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "carro", 
                            carro.getIdCarro()));
        }
        carroService.save(carro);
        return "redirect:/carro/listado";
    }

    @GetMapping("/eliminar/{idCarro}")
    public String carroEliminar(Carro carro) {
        carroService.delete(carro);
        return "redirect:/carro/listado";
    }

    @GetMapping("/modificar/{idCarro}")
    public String carroModificar(Carro carro, Model model) {
        carro = carroService.getCarro(carro);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("carro", carro);
        model.addAttribute("categorias", categorias);
        return "/carro/modifica";
    }
    
}