package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.EspecialidadDto;
import co.ucentral.EPS.App_Citas.dto.SedeDto;

import java.util.List;

public interface CrudSede {

    public SedeDto crear(SedeDto sedeDto);

    public List<SedeDto> buscarTodos();

    public SedeDto buscarPorNombre(String nombre);

}
