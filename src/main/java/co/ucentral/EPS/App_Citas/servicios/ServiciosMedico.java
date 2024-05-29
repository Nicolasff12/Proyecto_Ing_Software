package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.crud.CrudMedico;
import co.ucentral.EPS.App_Citas.dto.MedicoDto;
import co.ucentral.EPS.App_Citas.entidades.Medico;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioMedico;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMedico implements CrudMedico {

    private final ModelMapper modelMapper = new ModelMapper();


    RepositorioMedico repositorioMedico;

    public ServiciosMedico(RepositorioMedico repositorioMedico){
        this.repositorioMedico = repositorioMedico;
    }

    @Override
    public MedicoDto crear(MedicoDto medicoDto){
        if(medicoDto != null){
            Medico medico = repositorioMedico.save(modelMapper.map(medicoDto, Medico.class));
            return modelMapper.map(medico, MedicoDto.class);
        }else{
            return null;
        }
    }

    @Override
    public MedicoDto autenticarPorCedulayContrasenia(String cedula, String contrasenia) {

        Medico medico = repositorioMedico.buscarMedicoPorCedulayContrasenia(cedula,contrasenia);

        if(medico != null){
            return modelMapper.map(medico, MedicoDto.class);
        }else{
            return null;
        }
    }

}
