
package com.RentaCar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "socio")
@Data
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long socioId;

    private int usuarioId;
        
    @Temporal(TemporalType.DATE)
    private Date fechaAfiliacion;

    public Socio(int usuarioId, Date fechaAfiliacion) {
        this.usuarioId = usuarioId;
        this.fechaAfiliacion = fechaAfiliacion;
    }
    
    
    
}
