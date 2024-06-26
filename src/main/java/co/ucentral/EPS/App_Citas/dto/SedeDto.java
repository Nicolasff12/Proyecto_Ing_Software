package co.ucentral.EPS.App_Citas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SedeDto {

    private Integer id_sede;
    private String nombre;
    private String direccion;
    private Integer nconsultorios;
}
