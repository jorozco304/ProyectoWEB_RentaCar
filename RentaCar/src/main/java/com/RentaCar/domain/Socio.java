
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
    private Long id;

    private int usuario_id;
        
    @Temporal(TemporalType.DATE)
    private Date fecha_afiliacion;

    public Socio(int usuario_id, Date fecha_afiliacion) {
        this.usuario_id = usuario_id;
        this.fecha_afiliacion = fecha_afiliacion;
    }
    
    
    
}
