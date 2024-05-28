package co.ucentral.EPS.App_Citas.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Sede")

@ToString

public class Sede implements  Serializable{

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEDE_REL")
    @SequenceGenerator(name = "SEQ_SEDE_REL", sequenceName = "SEQ_SEDE_REL", allocationSize = 1)
    @Column(name = "SEDE_ID", nullable = false)
    private int id_sede;

    @Column(name = "SEDE_DESCRIPCION", nullable = false)
    private String nombre;

    @Column(name = "SEDE_DIRECCION", nullable = true)
    private String direccion;

    @Column(name = "SEDE_NUMCONSULTORIOS", nullable = true)
    private int nuemoerConsultorios;



}
