package co.ucentral.EPS.App_Citas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CitaDto implements Serializable{

    private long serial;
    private String fecha;
    private String observaciones;
    private String motivo;



}
