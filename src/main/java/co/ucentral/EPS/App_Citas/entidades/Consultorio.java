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

    @Column(name = "AUT_ID", nullable = false)
    private long id;
    @Column(name = "AUT_PISO", nullable = false)
    private int piso;
    @Column(name = "AUT_NUMERO_CONSULTORIO", nullable = false)
    private int numeroConsultorio;




}
