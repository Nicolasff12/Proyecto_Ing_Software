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
@Entity(name = "Persona")
@Table(name = "Persona_TAB")
@ToString
public class Persona implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONA_TAB")
    @SequenceGenerator(name = "SEQ_PERSONA_TAB", sequenceName = "SEQ_PERSONA_TAB", allocationSize = 1)
    @Column(name = "AUT_ID", nullable = false)
    private long id;

    @Column(name = "AUT_NOMBRE_COMPLETO", nullable = false)
    private String nombreCompleto;

    @Column(name = "AUT_CORREO", nullable = false)
    private String correo;

    @Column(name = "AUT_TELEFONO", nullable = false)
    private long telefono;

    @Column(name = "AUT_GENERO", nullable = false)
    private String genero;

    @Column(name = "AUT_TIPO", nullable = false)
    private Enum tipo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Persona> personas;


}
