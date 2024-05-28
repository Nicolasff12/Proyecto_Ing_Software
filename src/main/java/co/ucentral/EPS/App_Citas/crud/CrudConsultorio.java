package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.ConsultorioDto;

import java.util.List;

public interface CrudConsultorio {

    public ConsultorioDto crear(ConsultorioDto consultorioDto);
    public ConsultorioDto modificar(ConsultorioDto consultorioDto);
    public void borrar(ConsultorioDto consultorioDto);
    public void borrar(Integer pkEntidad);
    public List<ConsultorioDto> buscarTodos();
    public ConsultorioDto buscarID(Integer pkEntidad);
    public ConsultorioDto buscarIdConsultorio(Integer idConsultorio );
}
