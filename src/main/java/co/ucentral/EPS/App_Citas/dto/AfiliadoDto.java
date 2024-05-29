package co.ucentral.EPS.App_Citas.dto;

import co.ucentral.EPS.App_Citas.entidades.Cita;
import co.ucentral.EPS.App_Citas.entidades.Medico;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfiliadoDto {

    private int idAfiliado;
    private String nombre;
    private String correo;
    private int edad;
    private String cedula;
    private String estado;
    private String contrasenia;

}
