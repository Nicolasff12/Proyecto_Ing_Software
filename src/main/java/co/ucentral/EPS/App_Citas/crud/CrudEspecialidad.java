package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.EspecialidadDto;

import java.util.List;

public interface CrudEspecialidad {

    public EspecialidadDto crear(EspecialidadDto especialidadDto);

    public List<EspecialidadDto> buscarTodos();

    public EspecialidadDto buscarPorNombre(String nombre);
}
