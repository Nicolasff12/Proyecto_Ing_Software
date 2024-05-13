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
@Entity(name = "Usuario")
@Table(name = "Usuario_TAB")
@ToString
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_TAB")
    @SequenceGenerator(name = "SEQ_USUARIO_TAB", sequenceName = "SEQ_USUARIO_TAB", allocationSize = 1)

    @Column(name = "AUT_ID", nullable = false)
    private long idinicio;

    @Column(name = "AUT_NOMBRE_COMPLETO", nullable = false)
    private String nombreCompleto;



}
