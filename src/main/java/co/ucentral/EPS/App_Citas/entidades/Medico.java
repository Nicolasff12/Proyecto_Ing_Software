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
@Entity
@Table(name = "MEDICO")
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDICO_REL")
    @SequenceGenerator(name = "SEQ_MEDICO_REL", sequenceName = "SEQ_MEDICO_REL", allocationSize = 1)
    @Column(name = "MED_ID", nullable = false)
    private Integer idMedico;

    @Column(name = "MED_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "MED_EDAD", nullable = false)
    private int edad;

    @Column(name = "MED_ESTADO", nullable = false)
    private String estado;

    @Column(name = "MED_CEDULA", nullable = false)
    private String cedula;

    @Column(name = "MED_CONTRASENIA", nullable = false)
    private String contrasenia;


    @ManyToOne
    @JoinColumn(name = "SEDE_ID")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "ESP_ID")
    private Especialidad especialidad;

}
