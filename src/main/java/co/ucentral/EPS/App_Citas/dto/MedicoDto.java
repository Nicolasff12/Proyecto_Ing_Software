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
public class MedicoDto implements  Serializable{

    private long id;
    private String especialidad;

}
