package co.ucentral.EPS.App_Citas.dto;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsultorioDto implements  Serializable{

    private Integer serial;
    private Integer idConsultorio;
    private String nombre;
    private Sede sede;

}


