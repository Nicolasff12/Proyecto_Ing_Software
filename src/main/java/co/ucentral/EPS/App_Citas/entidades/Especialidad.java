package co.ucentral.EPS.App_Citas.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Especialidades")
@ToString
@Entity
public class Especialidad implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESPECIALIDAD_REL")
    @SequenceGenerator(name = "SEQ_ESPECIALIDAD_REL", sequenceName = "SEQ_ESPECIALIDAD_REL", allocationSize = 1)
    @Column(name = "ES_ID", nullable = false)
    private int idEspecialidad;

    @Column(name = "ES_NOMBRE", nullable = true)
    private String nombre;


}
