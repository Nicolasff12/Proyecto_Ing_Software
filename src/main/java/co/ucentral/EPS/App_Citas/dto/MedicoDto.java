package co.ucentral.EPS.App_Citas.dto;
import co.ucentral.EPS.App_Citas.entidades.Especialidad;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicoDto {

    private int idMedico;
    private String nombre;
    private int edad;
    private String estado;
    private String cedula;
    private String contrasenia;
    private Sede sede;
    private Especialidad especialidad;
}
