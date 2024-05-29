package co.ucentral.EPS.App_Citas.dto;
import co.ucentral.EPS.App_Citas.config.FechaConfig;
import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import co.ucentral.EPS.App_Citas.entidades.Especialidad;
import co.ucentral.EPS.App_Citas.entidades.Medico;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CitaDto implements Serializable{


    private int idcita;
    private String estado;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha;
    private String fechaFormateada;
    private LocalTime horaInicio;
    private Medico medico;
    private Sede sede;
    private Especialidad especialidad;
    private Afiliado afiliado;

    public String getFechaFormateada() {
        return FechaConfig.convertirFecha(this.fecha);
    }

}
