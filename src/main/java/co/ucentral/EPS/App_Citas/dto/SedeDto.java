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
public class SedeDto implements Serializable {

    private long id;
    private int ubicacion;
    private long telefono;
    private int capacidad;

}
