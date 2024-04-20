package co.ucentral.EPS.App_Citas.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Sede")
@Table(name = "Sede_TAB")
@ToString

public class Sede implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEDE_REL")
    @SequenceGenerator(name = "SEQ_SEDE_REL", sequenceName = "SEQ_SEDE_REL", allocationSize = 1)

    @Column(name = "AUT_ID", nullable = false)
    private long id;
    @Column(name = "AUT_UBICACION", nullable = false)
    private int ubicacion;
    @Column(name = "AUT_TELEFONO", nullable = false)
    private long telefono;
    @Column(name = "AUT_CAPACIDAD", nullable = false)
    private int capacidad;



}
