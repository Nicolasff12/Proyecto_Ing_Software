package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.crud.CrudEspecialidad;
import co.ucentral.EPS.App_Citas.dto.EspecialidadDto;
import co.ucentral.EPS.App_Citas.entidades.Especialidad;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioEspecialidad;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosEspecialidad implements CrudEspecialidad {
    private final ModelMapper modelMapper = new ModelMapper();

    RepositorioEspecialidad repositorioEspecialidad;

    public ServiciosEspecialidad(RepositorioEspecialidad repositorioEspecialidad){
        this.repositorioEspecialidad = repositorioEspecialidad;
    }

    @Override
    public EspecialidadDto crear(EspecialidadDto especialidadDto){
        if(especialidadDto != null){
            Especialidad especialidad = repositorioEspecialidad.save(modelMapper.map(especialidadDto, Especialidad.class));
            return modelMapper.map(especialidad, EspecialidadDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<EspecialidadDto> buscarTodos() {
        TypeToken<List<EspecialidadDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repositorioEspecialidad.findAll(), typeToken.getType());
    }

    @Override
    public EspecialidadDto buscarPorNombre(String nombre) {
        return modelMapper.map(repositorioEspecialidad.findByNombre(nombre),EspecialidadDto.class);
    }

}
