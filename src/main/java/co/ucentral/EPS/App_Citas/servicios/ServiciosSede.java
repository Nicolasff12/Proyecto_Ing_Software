package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.crud.CrudSede;
import co.ucentral.EPS.App_Citas.dto.SedeDto;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioSede;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosSede implements CrudSede {

    private final ModelMapper modelMapper = new ModelMapper();

    RepositorioSede repositorioSede;

    public ServiciosSede(RepositorioSede repositorioSede) {
        this.repositorioSede = repositorioSede;
    }

    @Override
    public SedeDto crear(SedeDto sedeDto) {
        if(sedeDto != null){
            Sede sede = repositorioSede.save(modelMapper.map(sedeDto, Sede.class));
            return modelMapper.map(sede, SedeDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<SedeDto> buscarTodos() {
        TypeToken<List<SedeDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioSede.findAll(), typeToken.getType());
    }

    @Override
    public SedeDto buscarPorNombre(String nombre) {
        return modelMapper.map(repositorioSede.findByNombre(nombre), SedeDto.class);
    }
}
