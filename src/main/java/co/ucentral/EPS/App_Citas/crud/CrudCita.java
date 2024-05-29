package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;
import co.ucentral.EPS.App_Citas.dto.CitaDto;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudCita {

    public CitaDto crear(CitaDto citaDto);

    public List<CitaDto> buscarTodos();

    public List<CitaDto> buscarTodosPorAfiliado(AfiliadoDto afiliadoDto);

    public List<CitaDto> buscarTodosPorFecha(LocalDateTime fecha);


    public CitaDto buscarCitaPorFechaPorSedePorAfiliadoYEstado(LocalDateTime fecha, int idSede, int idAfiliado, String estado);

    public List<String> buscarFechasPorEspecialidadPorSedeYFecha(int idEspecialidad, int idSede, LocalDateTime fecha);
}

