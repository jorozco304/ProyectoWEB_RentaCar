
package com.RentaCar.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Carro {
    private int cantidad; 

    public Item() {
    }

    public Item(Carro carro) {
        super.setIdCarro(carro.getIdCarro());
        super.setCategoria(carro.getCategoria());
        super.setModelo(carro.getModelo());
        super.setDetalle(carro.getDetalle());
        super.setPrecio(carro.getPrecio());
        super.setExistencias(carro.getExistencias());
        super.setImagen(carro.getImagen());
        super.setActivo(carro.isActivo());
        this.cantidad = 0;
    }
}