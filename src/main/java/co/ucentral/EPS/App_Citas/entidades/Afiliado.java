package co.ucentral.EPS.App_Citas.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Afiliado")
@ToString
@Entity
@Builder
public class Afiliado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AFILIADO_REL")
    @SequenceGenerator(name = "SEQ_AFILIADO_REL", sequenceName = "SEQ_AFILIADO_REL", allocationSize = 1)
    @Column(name = "AF_ID", nullable = false)
    private int idAfiliado;

    @Column(name = "AF_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "AF_CORREO", nullable = false)
    private String correo;

    @Column(name = "AF_EDAD", nullable = false)
    private int edad;

    @Column(name = "AF_CEDULA", nullable = false)
    private String cedula;

    @Column(name = "AF_ESTADO", nullable = false)
    private String estado;

    @Column(name = "AF_CONTRASENIA", nullable = false)
    private String contrasenia;


}
