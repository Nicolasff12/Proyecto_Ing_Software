package co.ucentral.EPS.App_Citas.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PersonaDto implements  Serializable{

    private long id;
    private String nombreCompleto;
    private String correo;
    private long telefono;
    private String genero;
    private Enum tipo;

}