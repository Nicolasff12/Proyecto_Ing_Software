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
public class UsuarioDto implements Serializable {

    private long idinicio;
    private String nombreCompleto;


}
