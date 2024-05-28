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

@Entity(name = "Consultorio")
@Table(name = "Consultorio_TAB")
@ToString
public class Consultorio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONSULTORIO_REL")
    @SequenceGenerator(name = "SEQ_CONSULTORIO_REL", sequenceName = "SEQ_CONSULTORIO_REL", allocationSize = 1)

    @Column(name = "con_serial", nullable = false)
    private int serial;

    @Column(name = "con_id", nullable = false)
    private int idConsultorio;

    @Column(name = "con_nombre")
    private String nombre;

    //@OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY, mappedBy =  "consultorio")
    //private List<Medico> medicos;

    @ManyToOne(targetEntity = Sede.class)
    @JoinColumn(name = "sed_id")
    private Sede sede;

    public Consultorio(int idConsultorio, String nombre, Sede sede) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.sede = sede;
    }

}
