package co.ucentral.EPS.App_Citas.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.text.DateFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CitaDto implements Serializable{

    private long id;
    private DateFormat fecha;
    private String observaciones;
    private String motivo;



}
