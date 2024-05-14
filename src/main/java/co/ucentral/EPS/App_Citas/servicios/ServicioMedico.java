package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.dto.MedicoDto;
import co.ucentral.EPS.App_Citas.entidades.Medico;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioMedico;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@Service
public class ServicioMedico implements Serializable {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final RepositorioMedico repositorioMedico;

    public MedicoDto registrar(MedicoDto medicoDto) {
        Medico elMedico = repositorioMedico.save(modelMapper.map(medicoDto, Medico.class));
        return modelMapper.map(elMedico, MedicoDto.class);
    }

    public List<MedicoDto> obtenerConsulta() {
        TypeToken<List<MedicoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioMedico.findAll(), typeToken.getType());
    }

    public MedicoDto obtenerMedico(long serial) {
        Medico medico = repositorioMedico.findById(serial).orElseThrow(null);
        return modelMapper.map(medico, MedicoDto.class);
    }

    public MedicoDto actualizar(MedicoDto medicoDto) {
        repositorioMedico.save(modelMapper.map(medicoDto, Medico.class));
        return medicoDto;
    }

    public void eliminar(long serial) {
        repositorioMedico.deleteById(serial);
    }

}
