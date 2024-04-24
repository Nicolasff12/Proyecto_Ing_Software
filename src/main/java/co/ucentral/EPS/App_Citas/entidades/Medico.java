package co.ucentral.EPS.App_Citas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Medico")
@Table(name = "Medico_TAB")
@ToString
public class Medico implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDICO_REL")
    @SequenceGenerator(name = "SEQ_MEDICO_REL", sequenceName = "SEQ_MEDICO_REL", allocationSize = 1)

    @Column(name = "AUT_ID", nullable = false)
    private long id;
    @Column(name = "AUT_ESPECIALIDAD", nullable = false)
    private String especialidad;
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "medico", cascade = CascadeType.ALL)
    //private List<Medico> medicos;

}
