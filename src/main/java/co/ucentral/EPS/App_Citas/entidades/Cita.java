package co.ucentral.EPS.App_Citas.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.text.DateFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cita")
@Table(name = "Cita_TAB")
@ToString
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CITA_REL")
    @SequenceGenerator(name = "SEQ_CITA_REL", sequenceName = "SEQ_CITA_REL", allocationSize = 1)

    @Column(name = "AUT_ID", nullable = false)
    private long id;

    @Column(name = "AUT_FEHCA", nullable = false)
    private DateFormat fecha;

    @Column(name = "AUT_OBSERVACIONES", nullable = false)
    private String observaciones;

    @Column(name = "AUT_MOTIVO", nullable = false)
    private String motivo;




}
