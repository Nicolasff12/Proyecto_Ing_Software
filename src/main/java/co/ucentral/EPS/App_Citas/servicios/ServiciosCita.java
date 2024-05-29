package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.crud.CrudCita;
import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;
import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import co.ucentral.EPS.App_Citas.entidades.Cita;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioCita;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiciosCita implements CrudCita {
    private final ModelMapper modelMapper = new ModelMapper();

    RepositorioCita repositorioCita;

    public ServiciosCita( RepositorioCita repositorioCita){
        this.repositorioCita = repositorioCita;
    }

    @Override
    public CitaDto crear(CitaDto citaDto) {
        if(citaDto != null){
            Cita cita = repositorioCita.save(modelMapper.map(citaDto, Cita.class));
            return modelMapper.map(cita, CitaDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<CitaDto> buscarTodos() {
        TypeToken<List<CitaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repositorioCita.findAll(), typeToken.getType());
    }

    @Override
    public List<CitaDto> buscarTodosPorAfiliado(AfiliadoDto afiliadoDto) {
        TypeToken<List<CitaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repositorioCita.findAllByAfiliado(modelMapper.map(afiliadoDto, Afiliado.class)), typeToken.getType());
    }

    @Override
    public List<CitaDto> buscarTodosPorFecha(LocalDateTime fecha) {
        TypeToken<List<CitaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repositorioCita.findAllByFecha(fecha), typeToken.getType());
    }

    @Override
    public CitaDto buscarCitaPorFechaPorSedePorAfiliadoYEstado(LocalDateTime fecha, int idSede, int idAfiliado, String estado) {

        Cita cita = repositorioCita.findCitaByFechaBySedeByAfiliadoAndEstado(fecha,idSede,idAfiliado,estado);

        if(cita != null){
            return modelMapper.map(cita, CitaDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<String> buscarFechasPorEspecialidadPorSedeYFecha(int idEspecialidad, int idSede, LocalDateTime fecha) {

        return repositorioCita.findFechasByEspecialidadBySedeAndFecha(idEspecialidad, idSede, fecha);
    }



}
